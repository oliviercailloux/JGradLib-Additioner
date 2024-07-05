package io.github.oliviercailloux.javagrade.graders;

import java.util.concurrent.CountDownLatch;

public class HelloImpl implements Hello{
private final CountDownLatch latch;
  
  public HelloImpl() {
    latch = new CountDownLatch(1);
  }
  
  @Override
  public void hello() {
    latch.countDown();
  }
  
  public CountDownLatch latch() {
    return latch;
  }
}
