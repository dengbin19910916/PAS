-- 用户身份
CREATE TABLE user_principal (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(30) NOT NULL,
  password VARCHAR(60) NOT NULL,
  account_non_expired BOOLEAN NOT NULL,
  account_non_locked BOOLEAN NOT NULL,
  credentials_non_expired BOOLEAN NOT NULL,
  enabled BOOLEAN NOT NULL,
  CONSTRAINT user_principal_username UNIQUE (username)
);

-- 用户权限
CREATE TABLE user_principal_authority (
  user_id BIGINT NOT NULL,
  authority VARCHAR(100) NOT NULL,
  CONSTRAINT user_principal_authority_user_authority UNIQUE (user_id, authority),
  CONSTRAINT user_principal_authority_userId FOREIGN KEY (user_id)
  REFERENCES user_principal (id) ON DELETE CASCADE
);

INSERT INTO user_principal (username, password, account_non_expired,
                            account_non_locked, credentials_non_expired, enabled)
VALUES ( -- password
         'Nicholas', '$2a$10$x0k/yA5qN8SP8JD5CEN.6elEBFxVVHeKZTdyv.RPra4jzRR5SlKSC',
         TRUE, TRUE, TRUE, TRUE
);
INSERT INTO user_principal_authority (user_id, authority)
VALUES (1, 'VIEW_TICKETS'), (1, 'VIEW_TICKET'), (1, 'CREATE_TICKET'),
  (1, 'EDIT_OWN_TICKET'), (1, 'VIEW_COMMENTS'), (1, 'CREATE_COMMENT'),
  (1, 'EDIT_OWN_COMMENT'), (1, 'VIEW_ATTACHMENT'), (1, 'CREATE_CHAT_REQUEST'),
  (1, 'CHAT');

INSERT INTO user_principal (username, password, account_non_expired,
                            account_non_locked, credentials_non_expired, enabled)
VALUES ( -- drowssap
         'Sarah', '$2a$10$JSxmYO.JOb4TT42/4RFzguaTuYkZLCfeND1bB0rzoy7wH0RQFEq8y',
         TRUE, TRUE, TRUE, TRUE
);
INSERT INTO user_principal_authority (user_id, authority)
VALUES (2, 'VIEW_TICKETS'), (2, 'VIEW_TICKET'), (2, 'CREATE_TICKET'),
  (2, 'EDIT_OWN_TICKET'), (2, 'VIEW_COMMENTS'), (2, 'CREATE_COMMENT'),
  (2, 'EDIT_OWN_COMMENT'), (2, 'VIEW_ATTACHMENT'), (2, 'CREATE_CHAT_REQUEST'),
  (2, 'CHAT');

INSERT INTO user_principal (username, password, account_non_expired,
                            account_non_locked, credentials_non_expired, enabled)
VALUES ( -- wordpass
         'Mike', '$2a$10$Lc0W6stzND.9YnFRcfbOt.EaCVO9aJ/QpbWnfjJLcMovdTx5s4i3G',
         TRUE, TRUE, TRUE, TRUE
);
INSERT INTO user_principal_authority (user_id, authority)
VALUES (3, 'VIEW_TICKETS'), (3, 'VIEW_TICKET'), (3, 'CREATE_TICKET'),
  (3, 'EDIT_OWN_TICKET'), (3, 'VIEW_COMMENTS'), (3, 'CREATE_COMMENT'),
  (3, 'EDIT_OWN_COMMENT'), (3, 'VIEW_ATTACHMENT'), (3, 'CREATE_CHAT_REQUEST'),
  (3, 'CHAT');

INSERT INTO user_principal (username, password, account_non_expired,
                            account_non_locked, credentials_non_expired, enabled)
VALUES ( -- green
         'John', '$2a$10$vacuqbDw9I7rr6RRH8sByuktOzqTheQMfnK3XCT2WlaL7vt/3AMby',
         TRUE, TRUE, TRUE, TRUE
);
INSERT INTO user_principal_authority (user_id, authority)
VALUES (4, 'VIEW_TICKETS'), (4, 'VIEW_TICKET'), (4, 'CREATE_TICKET'),
  (4, 'EDIT_OWN_TICKET'), (4, 'VIEW_COMMENTS'), (4, 'CREATE_COMMENT'),
  (4, 'EDIT_OWN_COMMENT'), (4, 'VIEW_ATTACHMENT'), (4, 'CREATE_CHAT_REQUEST'),
  (4, 'CHAT'), (4, 'EDIT_ANY_TICKET'), (4, 'DELETE_TICKET'),
  (4, 'EDIT_ANY_COMMENT'), (4, 'DELETE_COMMENT'), (4, 'VIEW_USER_SESSIONS'),
  (4, 'VIEW_CHAT_REQUESTS'), (4, 'START_CHAT');