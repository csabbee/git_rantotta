package com.eggs.domain;

/**
 * The implementations of this Interface should read MenuRepositories from some
 * sort of resource
 * 
 */
public interface MenuRepositoryReader {
    public MenuRepository read();
}
