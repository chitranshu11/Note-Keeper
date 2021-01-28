package com.chitranshu.noteapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public final class CategoryInfo implements Parcelable {
    private final String mCategoryId;
    private final String mTitle;
    private final List<ModuleInfo> mModules;

    public CategoryInfo(String courseId, String title, List<ModuleInfo> modules) {
        mCategoryId = courseId;
        mTitle = title;
        mModules = modules;
    }

    private CategoryInfo(Parcel source) {
        mCategoryId = source.readString();
        mTitle = source.readString();
        mModules = new ArrayList<>();
        source.readTypedList(mModules, ModuleInfo.CREATOR);
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<ModuleInfo> getModules() {
        return mModules;
    }

    public boolean[] getModulesCompletionStatus() {
        boolean[] status = new boolean[mModules.size()];

        for(int i=0; i < mModules.size(); i++)
            status[i] = mModules.get(i).isComplete();

        return status;
    }

    public void setModulesCompletionStatus(boolean[] status) {
        for(int i=0; i < mModules.size(); i++)
            mModules.get(i).setComplete(status[i]);
    }

    public ModuleInfo getModule(String moduleId) {
        for(ModuleInfo moduleInfo: mModules) {
            if(moduleId.equals(moduleInfo.getModuleId()))
                return moduleInfo;
        }
        return null;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryInfo that = (CategoryInfo) o;

        return mCategoryId.equals(that.mCategoryId);

    }

    @Override
    public int hashCode() {
        return mCategoryId.hashCode();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCategoryId);
        dest.writeString(mTitle);
        dest.writeTypedList(mModules);
    }

    public static final Creator<CategoryInfo> CREATOR =
            new Creator<CategoryInfo>() {

                @Override
                public CategoryInfo createFromParcel(Parcel source) {
                    return new CategoryInfo(source);
                }

                @Override
                public CategoryInfo[] newArray(int size) {
                    return new CategoryInfo[size];
                }
            };

}
