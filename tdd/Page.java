package tdd;

public interface Page {
    public String asString();
}

class AlbumPageExtractLocalTest extends HtmlFileTest implements Page {
    HtmlFileTest implements Page {
        public void testExtract() {
            AlbumPage albumPage = AlbumPageExtractor(this).AlbumPage();
            assertEquals(1, albumPage.getTotalPage());
        }
        public String asString(){
            return getTextFromFile("testdatas/albumpage2.html");
        }
    }
}
