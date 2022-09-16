package com.lab.testcontainer.postgre;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresSQLTestContainer extends PostgreSQLContainer<PostgresSQLTestContainer> {

  private static final String VERSION = "postgres:11.1";

  private static PostgresSQLTestContainer container;

  private PostgresSQLTestContainer() {
    super(VERSION);
  }

  public static PostgresSQLTestContainer getInstance() {
    if (container == null) {
      container = new PostgresSQLTestContainer();
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {
    //do nothing, JVM handles shut down
  }


}
