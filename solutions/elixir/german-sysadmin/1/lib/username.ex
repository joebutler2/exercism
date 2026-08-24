defmodule Username do
  def sanitize([], sanitized), do: sanitized
  def sanitize(username) do
    sanitize(username, '')
  end
  def sanitize([char | chars], sanitized) do
    case char do
      char when char in ?a..?z -> sanitize(chars, sanitized ++ [char])
      char when char == ?_ -> sanitize(chars, sanitized ++ [char])
      char when char == ?ä -> sanitize(chars, sanitized ++ [?a, ?e])
      char when char == ?ö -> sanitize(chars, sanitized ++ [?o, ?e])
      char when char == ?ü -> sanitize(chars, sanitized ++ [?u, ?e])
      char when char == ?ß -> sanitize(chars, sanitized ++ [?s, ?s])
      _ -> sanitize(chars, sanitized)
    end
  end
end
