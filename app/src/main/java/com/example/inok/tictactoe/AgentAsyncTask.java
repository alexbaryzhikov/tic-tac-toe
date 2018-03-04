package com.example.inok.tictactoe;

import android.os.AsyncTask;
import android.util.Log;

import com.example.inok.tictactoe.agents.Agent;

public class AgentAsyncTask extends AsyncTask<Void, Void, Integer> {

  private static final String TAG = "TAG_" + AgentAsyncTask.class.getSimpleName();
  private Agent agent;

  public AgentAsyncTask(Agent agent) {
    this.agent = agent;
  }

  @Override
  protected Integer doInBackground(Void... voids) {
    return agent.getAction();
  }

  @Override
  protected void onPostExecute(Integer position) {
    Log.d(TAG, "Agent move: " + position);
    GameController.onAgentClick(position);
  }

  @Override
  protected void onCancelled() {
    Log.d(TAG, "Agent task is cancelled");
  }
}
