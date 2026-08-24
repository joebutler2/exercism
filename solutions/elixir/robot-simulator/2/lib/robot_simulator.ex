defmodule RobotSimulator do
  @type robot() :: any()
  @type direction() :: :north | :east | :south | :west
  @type position() :: {integer(), integer()}
  defmodule Robot do
    defstruct direction: :north, position: {0, 0}
  end
  alias RobotSimulator.Robot
    
  @doc """
  Create a Robot Simulator given an initial direction and position.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction, position) :: robot() | {:error, String.t()}
  def create(direction \\ :north, position \\ {0, 0}) do
    cond do
      direction in [:north, :east, :south, :west] -> 
        cond do
          _is_position_valid?(position) ->
            %Robot{direction: direction, position: position}
          true -> {:error, "invalid position"}
        end
      true -> {:error, "invalid direction"}
    end
  end
  
  defp _is_position_valid?({_, _, _} = position), do: false
  defp _is_position_valid?({x, y} = position) do
    is_tuple(position) and tuple_size(position) == 2 and
      is_number(x) and is_number(y)
  end
  # Ie. the position is not a tuple
  defp _is_position_valid?(position), do: false

  @doc """
  Simulate the robot's movement given a string of instructions.

  Valid instructions are: "R" (turn right), "L", (turn left), and "A" (advance)
  """
  @spec simulate(robot, instructions :: String.t()) :: robot() | {:error, String.t()}
  def simulate(robot, instructions) do
    instructions
      |> String.split("", trim: true)
      |> Enum.reduce(robot, &handle_instruction/2)
  end

  defp handle_instruction(_, {:error, message}), do: {:error, message}
  defp handle_instruction(instruction, robot) do
    case instruction do
      "R" -> turn_right(robot)
      "L" -> turn_left(robot)
      "A" -> advance(robot)
      _ -> {:error, "invalid instruction"}
    end
  end

  defp turn_right(robot) do
    case robot.direction do
      :north -> %Robot{robot | direction: :east}
      :east -> %Robot{robot | direction: :south}
      :south -> %Robot{robot | direction: :west}
      :west -> %Robot{robot | direction: :north}
    end
  end

  defp turn_left(robot) do
    case robot.direction do
      :north -> %Robot{robot | direction: :west}
      :east -> %Robot{robot | direction: :north}
      :south -> %Robot{robot | direction: :east}
      :west -> %Robot{robot | direction: :south}
    end
  end

  defp advance(robot) do
    {x, y} = robot.position
    new_position = case robot.direction do
      :north -> {x, y + 1}
      :east -> {x + 1, y}
      :south -> {x, y - 1}
      :west -> {x - 1, y}
    end
     %Robot{robot | position: new_position}
  end

  @doc """
  Return the robot's direction.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec direction(robot) :: direction()
  def direction(%Robot{direction: direction} = robot) do
    direction
  end

  @doc """
  Return the robot's position.
  """
  @spec position(robot) :: position()
  def position(%Robot{position: position} = robot) do
    position
  end
end
