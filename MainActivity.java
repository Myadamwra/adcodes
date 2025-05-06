package com.example.popupmenu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPopupDialog, btnContextMenu;
    LinearLayout mainLayout;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopupDialog = findViewById(R.id.btnPopupDialog);
        btnContextMenu = findViewById(R.id.btnContextMenu);
        mainLayout = findViewById(R.id.mainLayout);

        // Popup dialog button
        btnPopupDialog.setOnClickListener(v -> showPopupDialog());

        // Show alert on normal click for context menu
        btnContextMenu.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please long press the button to see the context menu")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        // Register context menu
        registerForContextMenu(btnContextMenu);
    }

    // Show Popup Dialog
    private void showPopupDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Background")
                .setMessage("Do you want to change the background to blue?")
                .setPositiveButton("OK", (dialog, which) ->
                        mainLayout.setBackgroundColor(Color.parseColor("#64B5F6"))) // Light Blue
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Inflate Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }




    // Inflate Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select a Color");
    }

    // Handle Options Menu selections
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.option1) {
            mainLayout.setBackgroundColor(Color.parseColor("#81C784")); // Light Green
            return true;
        } else if (id == R.id.option2) {
            mainLayout.setBackgroundColor(Color.rgb(239, 154, 154)); // Light Red
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Handle Context Menu selections
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context1) {
            mainLayout.setBackgroundColor(Color.WHITE);
            return true;
        } else if (id == R.id.context2) {
            mainLayout.setBackgroundColor(Color.parseColor("#CE93D8"));
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
