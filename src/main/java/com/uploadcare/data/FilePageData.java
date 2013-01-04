package com.uploadcare.data;

import java.util.List;

public class FilePageData implements PageData<FileData> {

    public int page;
    public int pages;
    public List<FileData> results;

    @Override
    public List<FileData> getResults() {
        return results;
    }

    @Override
    public boolean hasMore() {
        return page < pages;
    }

}
