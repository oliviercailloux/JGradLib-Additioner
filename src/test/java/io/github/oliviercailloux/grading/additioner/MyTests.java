package io.github.oliviercailloux.grading.additioner;

import static com.google.common.base.Preconditions.checkState;
import static io.github.oliviercailloux.jaris.exceptions.Unchecker.URI_UNCHECKER;

import com.google.common.io.Resources;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTests {
  @SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory.getLogger(MyTests.class);

  @Test
  void testSomething() throws Exception {
    LOGGER.info("Started tests.");
    InputStream inp = io.github.oliviercailloux.javagrade.bytecode.Compiler.class.getResourceAsStream("Eclipse-prefs.epf");
    checkState(inp != null);
    final URL propertiesUrl = io.github.oliviercailloux.javagrade.bytecode.Compiler.class.getResource("Eclipse-prefs.epf");
    checkState(propertiesUrl != null);
    URI uri = URI_UNCHECKER.getUsing(() -> propertiesUrl.toURI());
    LOGGER.info("URI: {}.", uri);
    final Path propertiesPath = Path.of(uri);
  }
}
