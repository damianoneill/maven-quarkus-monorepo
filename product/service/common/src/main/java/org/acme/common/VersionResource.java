package org.acme.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Expose Git Tag Version information on a /version endpoint.
 */
@Path("/version")
public class VersionResource {

    /**
     * Return text content for version info.
     *
     * @return json object contain git tag info
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String version() {
        return this.readGitProperties();
    }

    /**
     * Read git properties string.
     *
     * @return the string
     */
    private String readGitProperties() {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream("git.json");
        try {
            return this.readFromInputStream(inputStream);
        } catch (final IOException e) {
            e.printStackTrace();
            return "Version information could not be retrieved";
        }
    }

    /**
     * Read from input stream string.
     *
     * @param inputStream the input stream
     * @return the string
     * @throws IOException the io exception
     */
    private String readFromInputStream(final InputStream inputStream) throws IOException {
        final StringBuilder resultStringBuilder = new StringBuilder();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}

