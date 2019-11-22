package chapter03;

/**
 * @author Seunghyun Kim
 * @since 2019-11-20
 */
public class HtmlUtil_1 {
    public static String testableHtml(
            PageData pageData,
            boolean includeSuiteSetup
    ) throws Exception {
        WikiPage wikiPage = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();
        if (pageData.hasAttribute("Test")) {
            if (includeSuiteSetup) {
                WikiPage suiteSetup =
                        PageCrawlerImpl.getInheritedPage(
                                SuiteResponder.SUITE_SETUP_NAME, wikiPage
                        );
                if (suiteSetup != null) {
                    WikiPagePath pagePath =
                            suiteSetup.getPageCrawler().getFullPath(suiteSetup);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -setup .")
                            .append(pagePathName)
                            .append("\n");
                }
            }
            WikiPage setup =
                    PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
            if (setup != null) {
                WikiPagePath setupPath =
                        wikiPage.getPageCrawler().getFullPath(setup);
                String setupPathName = PathParser.render(setupPath);
                buffer.append("!include -setup .")
                        .append(setupPathName)
                        .append("\n");
            }
        }
        buffer.append(pageData.getContent());
        if (pageData.hasAttribute("Test")) {
            WikiPage tearDown =
                    PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
            if (tearDown != null) {
                WikiPagePath tearDownPath =
                        wikiPage.getPageCrawler().getFullPath(tearDown);
                String tearDownPathName = PathParser.render(tearDownPath);
                buffer.append("!include -teardown .")
                        .append(tearDownPathName)
                        .append("\n");
            }
            if (includeSuiteSetup) {
                WikiPage suiteTeardown =
                        PageCrawlerImpl.getInheritedPage(
                                SuiteResponder.SUITE_TEARDOWN_NAME,
                                wikiPage
                        );
                if (suiteTeardown != null) {
                    WikiPagePath pagePath =
                            suiteTeardown.getPageCrawler().getFullPath(suiteTeardown);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -teardown .")
                            .append(pagePathName)
                            .append("\n");
                }
            }
        }
        pageData.setContent(buffer.toString());
        return pageData.getHtml();
    }
}




interface PageData {
    boolean hasAttribute(String attribute);
    WikiPage getWikiPage();
    String getContent();
    void setContent(String string);
    String getHtml();
}

interface WikiPage {
    PageCrawlerImpl getPageCrawler();
}

abstract class PageCrawler{
    static WikiPage getInheritedPage(String name, WikiPage wikiPage) {
        return null;
    }

    static WikiPagePath getFullPath(WikiPage wikiPage) {
        return null;
    }
}

class PageCrawlerImpl extends PageCrawler{
}

interface SuiteResponder{
    String SUITE_SETUP_NAME = "aa";
    String SUITE_TEARDOWN_NAME = "bb";
}

interface WikiPagePath{
}

class PathParser{
    public static String render(WikiPagePath wikiPagePath){
        return null;
    }
}