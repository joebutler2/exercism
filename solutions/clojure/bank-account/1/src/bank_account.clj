(ns bank-account)


(defn open-account []
  (agent 0)
)


(defn close-account [account]
  (send account (fn [_] nil))
)


(defn get-balance [account]
  @account
)


(defn update-balance [account value]
  (send account #(+ % value))
)

