defmodule Newsletter do
  def read_emails(path) do
    %{size: size} = File.stat! path
    cond do
      size > 0 ->
        File.read!(path)
          |> String.trim
          |> String.split("\n")
      true -> []
    end
  end

  def open_log(path) do
    case File.open!(path, [:write]) do
      {:ok, pid} -> pid
      _ -> nil
    end
  end

  def log_sent_email(pid, email) do
    IO.puts(pid, email)
  end

  def close_log(pid) do
    File.close(pid)
  end

  def send_newsletter(emails_path, log_path, send_fun) do
    logger = open_log(log_path)
    read_emails(emails_path)
      |> Enum.map(&(
           case send_fun.(&1) do
             :ok -> log_sent_email(logger, &1)
             _ -> nil
           end))
    close_log(logger)
  end
end
