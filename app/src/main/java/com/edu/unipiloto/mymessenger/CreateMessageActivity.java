package com.edu.unipiloto.mymessenger;

import static com.edu.unipiloto.mymessenger.ReceiveMessageActivity.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMessageActivity extends AppCompatActivity {

    private String history = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.messages);
        history = messageText != null ? messageText : "" + "\n";
        messageView.setText(messageText);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        String toSend = history + messageText;
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, toSend);
        startActivity(intent);
    }
}