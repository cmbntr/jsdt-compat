package ch.cmbntr.tracing.compat;

import java.io.Console;

import com.sun.tracing.Provider;
import com.sun.tracing.ProviderFactory;

public class JSDTCompatExample {

  private static final Milestone MILESTONE;

  static {
    // System.setProperty("sun.tracing.stream", "java.lang.System.out");

    ProviderFactory f = ProviderFactory.getDefaultFactory();
    MILESTONE = f.createProvider(Milestone.class);
  }

  public interface Milestone extends Provider {
    public void hit(String milestone);
  }

  public static void main(String[] args) {
    System.out.println(MILESTONE);

    Console con = System.console();
    if (con != null) {
      con.printf("please hit enter\n");
      con.readLine();
    }

    MILESTONE.hit("foo");
  }

}
