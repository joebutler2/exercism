defmodule RPG.CharacterSheet do
  def welcome() do
    IO.puts("Welcome! Let's fill out your character sheet together.")
  end

  def ask_name() do
    IO.gets("What is your character's name?\n") |> String.trim
  end

  def ask_class() do
    IO.gets("What is your character's class?\n") |> String.trim
  end

  def ask_level() do
    IO.gets("What is your character's level?\n") 
      |> String.trim 
      |> Integer.parse
      |> elem(0)
  end

  def run() do
    welcome()
    Map.new()
      |> Map.put(:name, ask_name())
      |> Map.put(:class, ask_class())
      |> Map.put(:level, ask_level())
      |> IO.inspect(label: "Your character")
  end
end
