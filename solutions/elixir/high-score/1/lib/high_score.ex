defmodule HighScore do
  def new() do
    %{}
  end

  def add_player(scores, name), do: add_player(scores, name, 0)
  def add_player(scores, name, score) do
    Map.put(scores, name, score)
  end

  def remove_player(scores, name) do
    {_, scores} = Map.pop(scores, name)
    scores
  end

  def reset_score(scores, name) do
     Map.put(scores, name, 0)
  end

  def update_score(scores, name, score) do
    if Map.has_key?(scores, name) do
      {_, scores} = Map.get_and_update(scores, name, &({&1, &1 + score}))
      scores
    else
      add_player(scores, name, score)
    end
  end
  
  def get_players(scores) do
    Map.keys(scores)
  end
end
