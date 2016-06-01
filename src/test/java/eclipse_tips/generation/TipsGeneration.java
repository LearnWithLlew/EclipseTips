package eclipse_tips.generation;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.learnwithllew.eclipsetips.EclipseTips;

import com.spun.util.io.FileUtils;
import com.spun.util.velocity.ContextAware.ContextAwareMap;
import com.spun.util.velocity.VelocityParser;

public class TipsGeneration
{
  private static final String upDown = "&#11014;/&#11015;";
  public void testName() throws Exception
  {
    EclipseTips.Mac();
  }
  @Test
  public void generateWindowsTips() throws Exception
  {
    createShortCuts("MacShortCuts", "Tips.java.template");
    createShortCuts("WindowsShortCuts", "Tips.java.template");
    createShortCuts("EclipseTips", "EclipseTips.java.template");
  }
  private void createShortCuts(String className, String template) throws IOException
  {
    File file = new File(
        "/Users/llewellyn/Github/EclipseTips/src/main/java/org/learnwithllew/eclipsetips/" + className + ".java");
    Tips[] tips = getTips();
    ContextAwareMap model = new ContextAwareMap("tips", tips);
    model.put("ClassName", className);
    String java = VelocityParser.parseFromClassPath(this.getClass(), template, model);
    FileUtils.writeFile(file, java);
  }
  private Tips[] getTips()
  {
    return new Tips[]{new Tips("Completions", new ShortCut("Auto Complete", "Ctrl + space", "Ctrl + space"),
        new ShortCut("QuickFix", "Ctrl + 1", "Command + 1"),
        new ShortCut("Search Help", "Ctrl + 3", "Command + 3"),
        new ShortCut("Generate (S)ource", "Alt + Shift + S", "Command + Alt + S")),
                      new Tips("Running", new ShortCut("Run", "Ctrl + F11", "Command + Shift + F11"),
                          new ShortCut("Debug", "F11", "Command + F11")),
                      new Tips("Refactorings",
                          new ShortCut("Extract (L)ocal Variable", "Alt + Shift + L", "Command + alt + L"),
                          new ShortCut("Extract (M)ethod", "Alt + Shift + M", "Command + alt + M"),
                          new ShortCut("(C)hange Method Signature", "Alt + Shift + C", "Command + alt + C"),
                          new ShortCut("(R)ename", "Alt + Shift + R", "Command + alt + R"),
                          new ShortCut("(I)nline", "Alt + Shift + I", "Command + alt + I")),
                      new Tips("Lines", new ShortCut("Delete Line", "Ctrl + D", "Command + D"),
                          new ShortCut("Grow Selection", "Alt + Shift + " + upDown,
                              "Ctrl + Shift + fn + " + upDown),
                          new ShortCut("Duplicate Line", "Ctrl + Alt + " + upDown, "Command + Alt + " + upDown),
                          new ShortCut("Move Line", "Alt + " + upDown, "Alt + " + upDown)),};
  }
}
