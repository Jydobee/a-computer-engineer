package com.acomputerengineer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);

        ArrayList<String> alPost = new ArrayList<>();
        alPost.add("DISPLAY LIST IN ALERTDIALOG IN ANDROID(SIMPLE LIST, RADIO BUTTON LIST, CHECK BOX LIST)");
        alPost.add("DISPLAY IMAGE GRID IN RECYCLERVIEW IN ANDROID");
        alPost.add("PICK IMAGE FROM GALLERY BEFORE AND AFTER KITKAT VERSION IN ANDROID(UPDATED)");
        alPost.add("HOW TO DISPLAY CANVAS ON IMAGEVIEW AND SAVE CANVAS AS BITMAP AND STORE IN SDCARD IN ANDROID");
        alPost.add("DRAW CIRCLE SHAPE IN IMAGEVIEW IN ANDROID");
        alPost.add("LIMIT NUMBER RANGE IN EDITTEXT USING INPUTFILTER IN ANDROID");
        alPost.add("RESIZE IMAGE DURING DECODE FROM FILE TO BITMAP IN ANDROID(TO PREVENT OOM)");
        alPost.add("VARIOUS MATERIAL DESIGNS FOR BUTTON IN ANDROID");
        alPost.add("SHARE IMAGE TO WHATSAPP IN ANDROID");
        alPost.add("CRUD FUNCTIONS IN SQLITE IN ANDROID");

        PostAdapter adapter = new PostAdapter(alPost);
        rv.setAdapter(adapter);
    }

    public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

        ArrayList<String> alPost;

        PostAdapter(ArrayList<String> alPost) {
            this.alPost = alPost;
        }

        public class PostViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView tvName;

            public PostViewHolder(View itemView) {
                super(itemView);
                cv = itemView.findViewById(R.id.cv);
                tvName = itemView.findViewById(R.id.tv_name);

                cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();

                        switch (position) {
                            case 0:
                                Intent intentListAlertDialog = new Intent(MainActivity.this, ListAlertDialogActivity.class);
                                startActivity(intentListAlertDialog);
                                break;
                            case 1:
                                Intent intentImageGrid = new Intent(MainActivity.this, ImageGridActivity.class);
                                startActivity(intentImageGrid);
                                break;
                            case 2:
                                Intent intentPickImage = new Intent(MainActivity.this, PickImageActivity.class);
                                startActivity(intentPickImage);
                                break;
                            case 3:
                                Intent intentCanvasDemo = new Intent(MainActivity.this, CanvasDemoActivity.class);
                                startActivity(intentCanvasDemo);
                                break;
                            case 4:
                                Intent intentCircleImageView = new Intent(MainActivity.this, CircleImageViewActivity.class);
                                startActivity(intentCircleImageView);
                                break;
                            case 5:
                                Intent intentLimitNumberRange = new Intent(MainActivity.this, LimitNumberRangeActivity.class);
                                startActivity(intentLimitNumberRange);
                                break;
                            case 6:
                                Intent intentResizeImageDecodeBitmap = new Intent(MainActivity.this, ResizeImageDecodeBitmapActivity.class);
                                startActivity(intentResizeImageDecodeBitmap);
                                break;
                            case 7:
                                Intent intentMaterialDesignButtons = new Intent(MainActivity.this, MaterialDesignButtonsActivity.class);
                                startActivity(intentMaterialDesignButtons);
                                break;
                            case 8:
                                Intent intentShareImageWhatsapp = new Intent(MainActivity.this, ShareImageWhatsappActivity.class);
                                startActivity(intentShareImageWhatsapp);
                                break;
                            case 9:
                                Intent intentSqliteCRUD = new Intent(MainActivity.this, SqliteCRUDActivity.class);
                                startActivity(intentSqliteCRUD);
                                break;
                        }

                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return alPost.size();
        }

        @Override
        public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
            PostViewHolder pvh = new PostViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(final PostViewHolder personViewHolder, int i) {
            personViewHolder.tvName.setText(String.valueOf(alPost.get(i)));
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
}
