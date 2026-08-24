defmodule HighScore do
  @initial_score 0

  def new(), do: %{}
  def add_player(scores, name, score \\ @initial_score) do
    Map.put(scores, name, score)
  end
  def remove_player(scores, name), do: Map.delete(scores, name)
  def reset_score(scores, name), do: Map.put(scores, name, @initial_score)
  def get_players(scores), do: Map.keys(scores)

  def update_score(scores, name, score) do
    if Map.has_key?(scores, name) do
      {_, scores} = Map.get_and_update(scores, name, &({&1, &1 + score}))
      scores
    else
      add_player(scores, name, score)
    end
  end
end
