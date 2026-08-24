let twoFer = (name: option(string)): string => {
  switch(name) {
  | None => "One for you, one for me."
  | Some(name) => "One for " ++ name ++ ", one for me."
  }
};

