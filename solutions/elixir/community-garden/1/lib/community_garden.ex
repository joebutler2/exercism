# Use the Plot struct as it is provided
defmodule Plot do
  @enforce_keys [:plot_id, :registered_to]
  defstruct [:plot_id, :registered_to]
end

defmodule CommunityGarden do
  def start(), do: start({})
  def start(opts) do
    Agent.start(fn -> %{next_id: 1, plots: Map.new()} end)
  end

  def list_registrations(pid) do
    Map.values(Agent.get(pid, & Map.get(&1, :plots)))
  end

  def register(pid, register_to) do
    Agent.get_and_update(pid, fn state ->
      id = Map.get(state, :next_id)
      plot = %Plot{plot_id: id, registered_to: register_to}
      new_state = state
        |> put_in([:plots, id], plot)
        |> Map.put(:next_id, id + 1)
      {plot, new_state}
    end)
  end

  def release(pid, plot_id) do
    Agent.get_and_update(pid, fn state ->
      {:ok, update_in(state, [:plots], & Map.delete(&1, plot_id))}
    end)
  end

  def get_registration(pid, plot_id) do
    Agent.get(pid, fn state ->
      case get_in(state, [:plots, plot_id]) do
        nil -> {:not_found, "plot is unregistered"}
        plot -> plot
      end
    end)
  end
end
