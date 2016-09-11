INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`)
VALUES (
  1,
  'John',
  'user@handioq.ru',
  '$2a$08$u4eRExB5CAPAGD3CX83Ld.n16SfecMsw5xJOK9Jy676PnPynpiifG',
  1
);

INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`)
VALUES (
  2,
  'Andrew',
  'admin@handioq.ru',
  '$2a$08$u4eRExB5CAPAGD3CX83Ld.n16SfecMsw5xJOK9Jy676PnPynpiifG',
  1
);

INSERT INTO `roles` (`id`, `name`) VALUES (1, 'ROLE_USER');
INSERT INTO `roles` (`id`, `name`) VALUES (2, 'ROLE_ADMIN');

INSERT INTO `user_roles` (`id`, `user_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `user_roles` (`id`, `user_id`, `role_id`) VALUES (2, 2, 2);
