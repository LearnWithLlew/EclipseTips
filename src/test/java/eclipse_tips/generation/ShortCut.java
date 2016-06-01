package eclipse_tips.generation;

public class ShortCut
{
  private String macShortcut;
  private String windowsShortcut;
  private String name;
  public ShortCut(String name, String windowsShortcut, String macShortcut)
  {
    this.name = name;
    this.windowsShortcut = windowsShortcut;
    this.macShortcut = macShortcut;
  }
  public String getMacShortcut()
  {
    return macShortcut;
  }
  public String getWindowsShortcut()
  {
    return windowsShortcut;
  }
  public String getName()
  {
    return name;
  }
  public String getShortcut(String forOs)
  {
    return "WindowsShortCuts".equals(forOs) ? getWindowsShortcut() : getMacShortcut();
  }
}
