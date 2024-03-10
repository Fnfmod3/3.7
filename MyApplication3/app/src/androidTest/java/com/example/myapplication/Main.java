package com.example.myapplication;

public class Main {
    public static class MainActivity extends AppCompatActivity {

        private FrameLayout frameLayout;
        private TextView textView;

        private int foundKeys = 0;

        private List<Key> keys = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            frameLayout = findViewById(R.id.frameLayout);
            textView = findViewById(R.id.textView);

            frameLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    float x = event.getX();
                    float y = event.getY();

                    for (Key key : keys) {
                        if (key.isTouched(x, y)) {
                            foundKeys++;
                            key.setVisibility(View.GONE);
                            break;
                        }
                    }

                    textView.setText("Координаты: (" + x + ", " + y + ")");

                    if (foundKeys == keys.size()) {
                        Toast.makeText(MainActivity.this, "Все ключи найдены!", Toast.LENGTH_SHORT).show();
                    }

                    return true;
                }
            });

            createKeys();
        }

        private void createKeys() {

            int[][] coordinates = {
                    {100, 100},
                    {200, 200},
                    {300, 300},
                    {400, 400},
                    {500, 500}
            };

            for (int i = 0; i < coordinates.length; i++) {
                Key key = new Key(this);
                key.setX(coordinates[i][0]);
                key.setY(coordinates[i][1]);
                frameLayout.addView(key);
                keys.add(key);
            }
        }
    }
}
