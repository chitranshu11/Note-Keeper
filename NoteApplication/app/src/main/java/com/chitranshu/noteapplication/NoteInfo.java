package com.chitranshu.noteapplication;

import android.os.Parcel;
import android.os.Parcelable;

public final class NoteInfo implements Parcelable {
    private CategoryInfo mCategory;
    private String mTitle;
    private String mText;

    public NoteInfo(CategoryInfo category, String title, String text) {
        mCategory = category;
        mTitle = title;
        mText = text;
    }

    private NoteInfo(Parcel parcel) {
        //In the order of writeParcel
        mCategory = parcel.readParcelable(CategoryInfo.class.getClassLoader());
        mTitle = parcel.readString();
        mText = parcel.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(mCategory,0);
        parcel.writeString(mTitle);
        parcel.writeString(mText);
    }

    public static final Parcelable.Creator<NoteInfo> CREATOR =
            new Creator<NoteInfo>() {
                @Override
                public NoteInfo createFromParcel(Parcel source) {
                    //Must be set in the order of wiritten
                    return new NoteInfo(source);
                }

                @Override
                public NoteInfo[] newArray(int size) {
                    return new NoteInfo[size];
                }
            };

}
