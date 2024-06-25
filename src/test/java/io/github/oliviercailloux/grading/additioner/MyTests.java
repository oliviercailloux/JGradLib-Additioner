package io.github.oliviercailloux.grading.additioner;

import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Verify.verify;
import static io.github.oliviercailloux.jaris.exceptions.Unchecker.URI_UNCHECKER;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteSource;
import com.google.common.io.MoreFiles;
import com.google.common.io.Resources;
import io.github.oliviercailloux.javagrade.JUnitHelper;
import io.github.oliviercailloux.javagrade.bytecode.Compiler;
import io.github.oliviercailloux.javagrade.graders.AdditionerTests;
import io.github.oliviercailloux.utils.Utils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.discovery.LauncherDiscoveryListeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTests {
  @SuppressWarnings("unused")
  private static final Logger LOGGER = LoggerFactory.getLogger(MyTests.class);

  @Test
  void testSomethingD() throws Exception {
    Compiler.eclipseCompile(ImmutableList.of(), ImmutableSet.of(), true, Optional.empty());
    String packageName = AdditionerTests.class.getPackageName();
    JUnitHelper.grade(packageName, null);
    JUnitHelper.grade(packageName, null);
    LOGGER.info("Graded.");
  }

  @Test
  void testSomething() throws Exception {
    BatchCompiler.compile(new String[] {"--release", "17", "Something.java"}, new PrintWriter(new StringWriter()),
        new PrintWriter(new StringWriter()), null);

    String packageName = AdditionerTests.class.getPackageName();
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
        .selectors(DiscoverySelectors.selectPackage(packageName)).build();
    try (LauncherSession session = LauncherFactory.openSession()) {
      Launcher launcher = session.getLauncher();
      launcher.discover(request);
    }
  }
}
