package com.example.levie.levie_1202152324_m3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class DaftarMinuman extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<water> mWaterData;
    private waterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_minuman);
        mRecyclerView = findViewById(R.id.recyclerview);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mWaterData = new ArrayList<>();
        mAdapter = new waterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);
        initializeData();

        //Jika ada lebih dari satu kolom, nonaktifkan swipe untuk memberhentikan
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }


        //class helper untuk membuat swipe dismiss dan drag and drop
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Tukar item dan beri tahu adaptornya
                Collections.swap(mWaterData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Hapus item dari kumpulan data
                mWaterData.remove(viewHolder.getAdapterPosition());

                //memberitahu adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //melampirkan helper ke recycler view
        helper.attachToRecyclerView(mRecyclerView);


    }

    private void initializeData(){
        //mengambil sumberdaya dari XML
        TypedArray watersImageRes = getResources().obtainTypedArray(R.array.water_array);
        String[] waterList = getResources().getStringArray(R.array.water_array);


        // Bersihkan data yang ada (untuk menghindari duplikasi)
        mWaterData.clear();

        for (int i=0; i<waterList.length; i++){
            //judul dari merk
            String[] judul = {"Aqua", "Ades", "Amidis", "Cleo", "Club", "Equil",
                    "Evian", "Leminerale", "Nestle", "Pristine", "Vit"};
            mWaterData.add(new water(judul[i], "Air minum kemasan bermerk "+judul[i], "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Pellentesque accumsan laoreet diam in viverra. Etiam consequat quis ligula id gravida." +
                    " Sed sed maximus nulla. Nunc pulvinar cursus justo eu luctus. Pellentesque pellentesque" +
                    " velit ut tortor imperdiet congue. Proin quam velit, luctus nec placerat eu, vehicula nec sapien. " +
                    "Vestibulum dapibus dictum dapibus. Sed a ipsum vel lectus pharetra auctor. " +
                    "Nam vel arcu quis orci elementum commodo. Duis luctus, risus in faucibus dapibus, diam augue " +
                    "feugiat enim, et eleifend libero augue ac massa.",
                    watersImageRes.getResourceId(i,0)));
        }
        watersImageRes.recycle();

        mAdapter.notifyDataSetChanged();


    }
}