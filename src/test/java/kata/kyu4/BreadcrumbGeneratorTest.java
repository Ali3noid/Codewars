package kata.kyu4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Breadcrumb generator - /kata/563fbac924106b8bf7000046/
 */
public class BreadcrumbGeneratorTest {
    @Test
    public void examplesTests() {
        // assertEquals("expected", "actual");

        String[] urls = new String[]{
            "http://google.ca/games/and-immunity-surfer-uber-skin-or/#top",
            "wwww.site.com/of-bioengineering-research-pippi-in-paper/index.html",
            "mysite.com/pictures/holidays.html",
            "www.codewars.com/users/GiacomoSorbi?ref=CodeWars",
            "www.codewars.com/pictures/bladder-a-by-paper-and-research/Giacomo-Sorbi?ref=CodeWars",
            "www.microsoft.com/docs/index.htm#top",
            "mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp",
            "www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi",
            "https://www.linkedin.com/in/giacomosorbi",
            "www.agcpartners.co.uk/"};

        String[] seps = new String[]{" * ", " >>> ", " : ", " / ", " + ", " * ", " > ", " + ", " * ", " * "};

        String[] anss = new String[]{
            "<a href=\"/\">HOME</a> * <a href=\"/games/\">GAMES</a> * <span class=\"active\">ISUS</span>",
            "<a href=\"/\">HOME</a> >>> <span class=\"active\">BRPP</span>",
            "<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
            "<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
            "<a href=\"/\">HOME</a> + <a href=\"/pictures/\">PICTURES</a> + <a href=\"/pictures/bladder-a-by-paper-and-research/\">BPR</a> + <span class=\"active\">GIACOMO SORBI</span>",
            "<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
            "<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>",
            "<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>",
            "<a href=\"/\">HOME</a> * <a href=\"/in/\">IN</a> * <span class=\"active\">GIACOMOSORBI</span>",
            "<span class=\"active\">HOME</span>"};

        for (int i = 0; i < 8; i++) {
            System.out.println(" \nTest with : " + urls[i]);
            String actual = BreadcrumbGenerator.generate_bc(urls[i], seps[i]);
            if (!actual.equals(anss[i])) {
                System.out.println(String.format("Expected : %s", reformat(anss[i])));
                System.out.println(String.format("Actual :   %s", reformat(actual)));
            }
            assertEquals(anss[i], actual);
        }
    }

    String reformat(String s) {
        return s.replace("<", "<");
    }
}