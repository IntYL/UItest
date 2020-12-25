package com.example.uitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uitest.databinding.GuideitemBinding;

import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.ViewBindHolder> {
    private List<GuideBean> dataList;
    private Context mContext;

    public GuideAdapter(List<GuideBean> dataList, Context context) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewBindHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GuideitemBinding f = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.guideitem, null, false);
        return new ViewBindHolder(f);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewBindHolder holder, int position) {
        GuideitemBinding guideitemBinding = holder.getGuideitemBinding();
        guideitemBinding.setGuideBean(dataList.get(position));
        guideitemBinding.executePendingBindings();//解决dataBinding闪烁问题
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static class ViewBindHolder extends RecyclerView.ViewHolder {
        private GuideitemBinding guideitemBinding;

        public GuideitemBinding getGuideitemBinding() {
            return guideitemBinding;
        }

        public ViewBindHolder(@NonNull GuideitemBinding guideitemBinding) {
            super(guideitemBinding.getRoot());
            this.guideitemBinding = guideitemBinding;
        }
    }
}
/**
 * Created By leiyao6 on
 */