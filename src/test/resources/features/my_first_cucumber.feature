Feature: my first Cucumber Feature

  Scenario: compare prices from DB and site
    Given Get products from DB
    And compare product prices with site version

