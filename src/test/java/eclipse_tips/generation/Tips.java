package eclipse_tips.generation;

public class Tips
{
  public String getName()
  {
    return name;
  }
  public ShortCut[] getTips()
  {
    return tips;
  }
  private String name;
  private ShortCut[]  tips;
  public Tips(String name, ShortCut... tips)
  {
    this.name = name;
    this.tips = tips;
  }
}
