package org.jsoup.integration.servlets;

import org.jsoup.integration.TestServer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class DeflateServlet extends BaseServlet {
    public static final String Url;
    public static final String TlsUrl;
    static {
        TestServer.ServletUrls urls = TestServer.map(DeflateServlet.class);
        Url = urls.url;
        TlsUrl = urls.tlsUrl;
    }

    @Override
    protected void doIt(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType(TextHtml);
        res.setStatus(HttpServletResponse.SC_OK);
        res.setHeader("Content-Encoding", "deflate");

        String doc = "<p>Hello, World!<p>That should be enough, right?<p>Hello, World!<p>That should be enough, right?";

        DeflaterOutputStream stream = new DeflaterOutputStream(
            res.getOutputStream(),
            new Deflater(Deflater.BEST_COMPRESSION, true)); // true = nowrap zlib headers

       stream.write(doc.getBytes(StandardCharsets.UTF_8));
       stream.close();
    }

    // allow the servlet to run as a main program, for local test
    public static void main(String[] args) {
        TestServer.start();
        System.out.println(Url);
    }
}
