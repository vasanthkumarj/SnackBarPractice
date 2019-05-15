package com.vasanthkumarj15.snackbarpractice;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private Toolbar t;
    private CoordinatorLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.tool);
        layout=findViewById(R.id.rootLayout);
        t.setTitle("Snack Bar Practice");
        t.inflateMenu(R.menu.menu_main);

        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.simple:
                        simpleSnackBar();
                        break;

                    case R.id.styled:
                        styledSnackBar();
                        break;

                    case R.id.withAction:
                        actionSnackBar();
                        break;

                     default:
                         break;
                }

                return true;
            }
        });

    }

    private void simpleSnackBar() {
        Snackbar.make(layout,"Simple Called",Snackbar.LENGTH_SHORT).show();
    }

    private void styledSnackBar() {

    }

    private void actionSnackBar() {
        final Snackbar snack=Snackbar.make(layout,"Called Action",Snackbar.LENGTH_LONG);
        snack.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snack.make(layout,"Return Action",Snackbar.LENGTH_SHORT).show();

            }

        });
        snack.show();
    }
}
