package com.google.jstestdriver.servlet.fileset;

import java.util.Collection;

import com.google.inject.Inject;
import com.google.jstestdriver.FileInfo;
import com.google.jstestdriver.FilesCache;
import com.google.jstestdriver.SlaveBrowser;

/**
 * Handles uploads to the server file cache.
 * @author corbinrsmith@gmail.com (Cory Smith)
 */
public class ServerFileUpload implements FileSetRequestHandler<String> {
  public static final String ACTION = "serverFileUpload";
  private final FilesCache filesCache;

  @Inject
  public ServerFileUpload(FilesCache filesCache) {
    this.filesCache = filesCache;
    
  }

  public String handle(SlaveBrowser browser, Collection<FileInfo> data) {
    for (FileInfo f : data) {
      filesCache.addFile(f);
    }
    return "{ok}";
  }
  

  public boolean canHandle(String action) {
    return ACTION.equalsIgnoreCase(action);
  }
}