package com.chitranshu.noteapplication;

public final class NoteInfo {
    private CategoryInfo mCategory;
    private String mTitle;
    private String mText;

    public NoteInfo(CategoryInfo category, String title, String text) {
        mCategory = category;
        mTitle = title;
        mText = text;
    }

    public CategoryInfo getCategory() {
        return mCategory;
    }

    public void setCourse(CategoryInfo category) {
        mCategory = category;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mCategory.getCategoryId() + "|" + mTitle + "|" + mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteInfo that = (NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

}
