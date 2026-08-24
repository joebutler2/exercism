defmodule HighSchoolSweetheart do
  import String, only: [first: 1, upcase: 1, trim_leading: 1, split: 1]

  def first_letter(name) do
    name |> trim_leading |> first
  end

  def initial(name) do
    name 
      |> first_letter
      |> upcase
      |> Kernel.<>(".")
  end

  def initials(full_name) do
    full_name |> split |> Enum.map(&(initial(&1))) |> Enum.join(" ")
  end

  def pair(full_name1, full_name2) do
    """
         ******       ******
       **      **   **      **
     **         ** **         **
    **            *            **
    **                         **
    **     #{initials(full_name1)}  +  #{initials(full_name2)}     **
     **                       **
       **                   **
         **               **
           **           **
             **       **
               **   **
                 ***
                  *
    """
  end
end
