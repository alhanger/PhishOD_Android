package com.phishod.android.ui;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.phishin.PhishInApi;
import com.phishin.entities.Era;
import com.phishod.android.R;
import com.phishod.android.ui.views.EraHeaderRowView;
import com.phishod.android.ui.views.YearRowView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import rx.Observable;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class YearsFragmentFragment extends ListFragment {

    public static final String TAG = YearsFragmentFragment.class.getName();

    private PhishInApi mApi;

    public static YearsFragmentFragment newInstance() {
        YearsFragmentFragment fragment = new YearsFragmentFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public YearsFragmentFragment() {
    }

    public void setApi(PhishInApi api) {
        mApi = api;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        Observable<List<Era>> eraObservable = mApi.getEras();
        eraObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Era>>() {
                    @Override
                    public void call(List<Era> eras) {
                        YearsAdapter adapter = new YearsAdapter(getActivity().getApplicationContext(), eras);
                        setListAdapter(adapter);
                    }
                });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }

    private static class YearsAdapter extends BaseAdapter {

        private static final int VIEW_TYPE_ERA = 0;
        private static final int VIEW_TYPE_YEAR = 1;

        private Context mContext;
        private List<Era> mEras = new LinkedList<Era>();
        private List<String> mEraNames = new ArrayList<String>();
        private List<String> mData = new ArrayList<String>();

        public YearsAdapter(Context context, List<Era> eras) {
            mContext = context;
            mEras.addAll(eras);
            Collections.sort(mEras, new Comparator<Era>() {
                @Override
                public int compare(Era era, Era era2) {
                    return era2.getName().compareTo(era.getName());
                }
            });
            for (Era era : mEras) {
                mData.add(era.getName());
                mEraNames.add(era.getName());
                ListIterator<String> iterator = era.getYears().listIterator(era.getYears().size());
                while (iterator.hasPrevious()) {
                    mData.add(iterator.previous());
                }

            }
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            String name = mData.get(position);
            if (mEraNames.contains(name)) {
                return VIEW_TYPE_ERA;
            }
            return VIEW_TYPE_YEAR;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return getItemViewType(position) == VIEW_TYPE_YEAR;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            String item = getItem(position);
            int viewType = getItemViewType(position);

            if (convertView == null) {
                switch (viewType){
                    case VIEW_TYPE_ERA: {
                        convertView = new EraHeaderRowView(mContext);
                    }
                    break;
                    case VIEW_TYPE_YEAR: {
                        convertView = new YearRowView(mContext);
                    }
                    break;
                }
            }

            switch (viewType) {
                case VIEW_TYPE_ERA: {
                    ((EraHeaderRowView) convertView).setEra(item);
                }
                break;
                case VIEW_TYPE_YEAR: {
                    ((YearRowView) convertView).setYear(item);
                }
                break;
            }
            return convertView;
        }
    }
}
