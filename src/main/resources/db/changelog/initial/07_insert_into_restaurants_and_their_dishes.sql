INSERT INTO restaurants (name, address, description)
VALUES ('Italian Bistro', 'Chuy 112', 'Authentic Italian cuisine with a focus on traditional pasta dishes.'),
       ('Sushi Roll House', 'Kievskaya 32', 'Fresh sushi and sashimi with a variety of Japanese delicacies.'),
       ('Mexican Cantina', 'Togolok Moldo 88', 'Vibrant Mexican restaurant offering tacos, enchiladas, and margaritas.'),
       ('French Brasserie', 'Bokonbaeva 354',
        'Elegant French dining with a selection of pastries and gourmet dishes.'),
       ('Indian Spice Market', 'Maldybaeva 21', 'Rich Indian curries and spicy dishes with traditional flavors.'),
       ('American Grill', 'Ahunbaeva 57', 'Classic American grill with burgers, fries, and milkshakes.'),
       ('Chinese Dragon', '7 Aprel 40', 'Traditional Chinese dishes including dim sum, dumplings, and stir-fries.'),
       ('Thai Delight', 'Abdrakhmanova 79', 'Authentic Thai dishes with a variety of curries, noodles, and soups.'),
       ('Mediterranean Feast', 'Karpinkka 3', 'Mediterranean cuisine featuring hummus, kebabs, and fresh salads.'),
       ('Greek Tavern', 'Shopokova 41', 'Traditional Greek food with gyros, moussaka, and baklava.');

-- Italian Bistro
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Spaghetti Carbonara', 'Classic spaghetti with creamy carbonara sauce and pancetta.', 500, 1),
       ('Margherita Pizza', 'Traditional pizza topped with fresh tomatoes, mozzarella, and basil.', 409, 1),
       ('Lasagna', 'Layers of pasta with rich meat sauce and cheese.', 392, 1),
       ('Fettuccine Alfredo', 'Creamy Alfredo sauce with fettuccine pasta.', 432, 1),
       ('Caprese Salad', 'Tomato, mozzarella, and basil drizzled with balsamic glaze.', 321, 1),
       ('Bruschetta', 'Toasted bread topped with a mixture of tomatoes, basil, and garlic.', 345, 1),
       ('Ravioli', 'Stuffed pasta served with marinara sauce.', 457, 1),
       ('Tiramisu', 'Classic Italian dessert made with coffee-soaked ladyfingers and mascarpone cheese.', 546, 1),
       ('Panzanella Salad', 'Bread salad with tomatoes, cucumbers, and red onions.', 439, 1),
       ('Baked Ziti', 'Ziti pasta baked with marinara sauce and mozzarella cheese.', 412, 1);

-- Sushi Roll House
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('California Roll', 'Sushi roll with crab, avocado, and cucumber.', 349, 2),
       ('Spicy Tuna Roll', 'Roll with spicy tuna, cucumber, and avocado.', 511, 2),
       ('Dragon Roll', 'Roll with eel, avocado, and cucumber, topped with spicy mayo.', 513, 2),
       ('Salmon Sashimi', 'Fresh slices of salmon served with soy sauce and wasabi.', 612, 2),
       ('Miso Soup', 'Traditional Japanese soup with tofu, seaweed, and miso paste.', 444, 2),
       ('Tempura', 'Lightly battered and fried shrimp and vegetables.', 410, 2),
       ('Edamame', 'Steamed young soybeans sprinkled with sea salt.', 435, 2),
       ('Yakitori', 'Grilled chicken skewers glazed with soy sauce.', 398, 2),
       ('Prawn Tempura Roll', 'Roll with prawn tempura, avocado, and cucumber.', 412, 2),
       ('Japanese Cheesecake', 'Light and fluffy cheesecake with a hint of vanilla.', 346, 2);

-- Mexican Cantina
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Tacos', 'Soft tortillas filled with seasoned beef, lettuce, and cheese.', 348, 3),
       ('Enchiladas', 'Corn tortillas rolled and stuffed with chicken, topped with enchilada sauce.', 412, 3),
       ('Quesadilla', 'Flour tortilla filled with cheese and chicken or beef.', 510, 3),
       ('Guacamole', 'Avocado dip served with tortilla chips.', 436, 3),
       ('Churros', 'Fried dough pastries rolled in cinnamon sugar.', 435, 3),
       ('Fajitas', 'Grilled chicken or beef with peppers and onions, served with tortillas.', 513, 3),
       ('Tamales', 'Corn dough stuffed with meat and wrapped in corn husks.', 411, 3),
       ('Carnitas', 'Slow-cooked pulled pork served with tortillas.', 612, 3),
       ('Sopes', 'Thick tortillas topped with beans, meat, and salsa.', 349, 3),
       ('Tres Leches Cake', 'Moist sponge cake soaked in three kinds of milk.', 236, 3);

-- French Brasserie
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Croissant', 'Flaky, buttery pastry perfect for breakfast.', 323, 4),
       ('Coq au Vin', 'Chicken braised in red wine with mushrooms and bacon.', 315, 4),
       ('Beef Bourguignon', 'Slow-cooked beef stew with red wine, onions, and carrots.', 516, 4),
       ('Quiche Lorraine', 'Savory pie with bacon, cheese, and egg custard.', 412, 4),
       ('Escargot', 'Snails cooked in garlic butter and herbs.', 511, 4),
       ('Ratatouille', 'Vegetable stew with zucchini, eggplant, and bell peppers.', 314, 4),
       ('Bouillabaisse', 'Traditional seafood stew from Provence.', 417, 4),
       ('Crème Brûlée', 'Vanilla custard with a caramelized sugar top.', 437, 4),
       ('Duck Confit', 'Duck leg slowly cooked in its own fat, served with crispy skin.', 518, 4),
       ('Madeleine', 'Small sponge cakes with a light, buttery flavor.', 344, 4);

-- Indian Spice Market
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Chicken Tikka Masala', 'Grilled chicken pieces in a creamy tomato sauce.', 414, 5),
       ('Lamb Rogan Josh', 'Spicy lamb curry with a rich, flavorful sauce.', 515, 5),
       ('Palak Paneer', 'Spinach curry with cubes of Indian cheese.', 412, 5),
       ('Samosas', 'Deep-fried pastry stuffed with spiced potatoes and peas.', 336, 5),
       ('Butter Chicken', 'Tender chicken cooked in a buttery tomato sauce.', 413, 5),
       ('Chana Masala', 'Spicy chickpea curry with aromatic spices.', 511, 5),
       ('Naan', 'Soft, leavened bread baked in a tandoor oven.', 232, 5),
       ('Raita', 'Cool yogurt sauce with cucumber and spices.', 343, 5),
       ('Biryani', 'Spiced rice dish with chicken or lamb and aromatic spices.', 314, 5),
       ('Gulab Jamun', 'Sweet, fried dough balls soaked in rosewater syrup.', 345, 5);

-- American Grill
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Cheeseburger', 'Juicy beef patty with melted cheese, lettuce, and tomato.', 311, 6),
       ('BBQ Ribs', 'Tender ribs smothered in barbecue sauce.', 316, 6),
       ('Buffalo Wings', 'Spicy chicken wings served with celery and blue cheese dressing.', 410, 6),
       ('Onion Rings', 'Crispy fried onion rings with a tangy dipping sauce.', 335, 6),
       ('Hot Dog', 'Grilled sausage served in a bun with various toppings.', 456, 6),
       ('Mac and Cheese', 'Creamy macaroni and cheese baked to perfection.', 329, 6),
       ('Club Sandwich', 'Triple-layered sandwich with turkey, bacon, and avocado.', 312, 6),
       ('Caesar Salad', 'Crisp romaine lettuce with Caesar dressing, croutons, and Parmesan.', 347, 6),
       ('Milkshake', 'Classic milkshake available in chocolate, vanilla, or strawberry.', 234, 6),
       ('Apple Pie', 'Warm apple pie with a flaky crust.', 455, 6);

-- Chinese Dragon
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Kung Pao Chicken', 'Stir-fried chicken with peanuts and spicy sauce.', 412, 7),
       ('Sweet and Sour Pork', 'Crispy pork in a tangy sweet and sour sauce.', 313, 7),
       ('Dumplings', 'Steamed dumplings filled with pork and vegetables.', 439, 7),
       ('Hot and Sour Soup', 'Spicy and tangy soup with mushrooms and tofu.', 436, 7),
       ('Beef with Broccoli', 'Tender beef slices stir-fried with broccoli in a savory sauce.', 311, 7),
       ('Spring Rolls', 'Crispy rolls filled with vegetables and meat.', 447, 7),
       ('General Tso Chicken', 'Fried chicken in a sweet and spicy sauce.', 412, 7),
       ('Fried Rice', 'Stir-fried rice with vegetables, eggs, and choice of meat.', 438, 7),
       ('Peking Duck', 'Crispy duck served with pancakes and hoisin sauce.', 416, 7),
       ('Mango Pudding', 'Creamy mango-flavored dessert with a hint of coconut.', 555, 7);

-- Thai Delight
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Pad Thai', 'Stir-fried rice noodles with shrimp, tofu, and peanuts.', 412, 8),
       ('Green Curry', 'Spicy green curry with chicken, bamboo shoots, and eggplant.', 313, 8),
       ('Tom Yum Soup', 'Hot and sour soup with shrimp and mushrooms.', 437, 8),
       ('Massaman Curry', 'Rich and mild curry with beef, potatoes, and peanuts.', 414, 8),
       ('Som Tum', 'Spicy green papaya salad with lime and peanuts.', 439, 8),
       ('Pad See Ew', 'Stir-fried wide rice noodles with chicken and broccoli.', 411, 8),
       ('Thai Spring Rolls', 'Crispy rolls with vegetables and glass noodles.', 436, 8),
       ('Panang Curry', 'Creamy red curry with beef and bell peppers.', 413, 8),
       ('Thai Iced Tea', 'Sweetened iced tea with a hint of vanilla and cream.', 434, 8),
       ('Sticky Rice with Mango', 'Sweet sticky rice served with fresh mango slices.', 345, 8);

-- Mediterranean Feast
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Hummus', 'Creamy blend of chickpeas and tahini, served with pita bread.', 436, 9),
       ('Falafel', 'Deep-fried chickpea balls served with tahini sauce.', 437, 9),
       ('Gyro', 'Pita filled with seasoned lamb, tzatziki sauce, and vegetables.', 411, 9),
       ('Shawarma', 'Marinated chicken or beef served in pita with pickles and tahini.', 412, 9),
       ('Tabbouleh', 'Refreshing salad with bulgur wheat, tomatoes, and parsley.', 438, 9),
       ('Dolmas', 'Grape leaves stuffed with rice, pine nuts, and herbs.',549, 9),
       ('Kebabs', 'Grilled skewers of marinated meat, served with rice and vegetables.', 414, 9),
       ('Baklava', 'Sweet pastry made with layers of filo dough, honey, and nuts.', 345, 9),
       ('Moussaka', 'Layered casserole with eggplant, ground beef, and béchamel sauce.', 513, 9),
       ('Greek Salad', 'Salad with cucumbers, tomatoes, olives, and feta cheese.', 657, 9);

-- Greek Tavern
INSERT INTO dishes (name, description, price, restaurant_id)
VALUES ('Gyro Plate', 'Seasoned lamb served with rice, tzatziki, and pita bread.', 413, 10),
       ('Souvlaki', 'Grilled skewers of marinated meat, served with vegetables and pita.', 412, 10),
       ('Spanakopita', 'Flaky pastry filled with spinach and feta cheese.', 458, 10),
       ('Tzatziki', 'Cool cucumber and yogurt dip served with pita bread.', 555, 10),
       ('Moussaka', 'Layers of eggplant, ground beef, and béchamel sauce.', 514, 10),
       ('Greek Salad', 'Fresh salad with cucumbers, tomatoes, olives, and feta cheese.', 327, 10),
       ('Dolmades', 'Grape leaves stuffed with rice, herbs, and pine nuts.', 349, 10),
       ('Baklava', 'Sweet dessert made with layers of filo dough, nuts, and honey.', 436, 10),
       ('Feta Cheese Plate', 'Assorted feta cheese with olives and tomatoes.', 436, 10),
       ('Loukoumades', 'Honey-soaked dough balls, a traditional Greek dessert.', 345, 10);
