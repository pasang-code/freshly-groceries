INSERT INTO brand (id, name, slogan, founding_year) VALUES
                                                        (1, 'Coca-Cola', 'Taste the Feeling', '1892'),
                                                        (2, 'Nestlé', 'Good Food Good Life', '1866'),
                                                        (3, 'Danone', 'One Planet One Health', '1919'),
                                                        (4, 'Lay''s', 'Betcha Can''t Eat Just One', '1932'),
                                                        (5, 'Heinz', '57 Varieties', '1869');

INSERT INTO category (id, name, description, image_url, featured, display_order) VALUES
                                                                                     (1, 'Drank', 'Frisdranken en koffie', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Drank&font=open-sans', false, 1),
                                                                                     (2, 'Snacks', 'Chips en zoete snacks', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Snacks&font=open-sans', false, 2),
                                                                                     (3, 'Zuivel', 'Yogurt en melkproducten', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Zuivel&font=open-sans', false, 3),
                                                                                     (4, 'Sauzen', 'Sauzen en condiments', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Sauzen&font=open-sans', false, 4),
                                                                                     (5, 'SuperDeals', 'Sterk afgeprijsde producten en tijdelijke acties', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=SuperDeals&font=open-sans', true, 5),
                                                                                     (6, 'Nieuwkomers', 'Nieuwe producten in ons assortiment', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Nieuwkomers&font=open-sans', true, 6),
                                                                                     (7, 'Bestsellers', 'Populaire producten', 'https://placehold.co/600x400/e8f5e9/2d6a4f?text=Bestsellers&font=open-sans', true, 7);

INSERT INTO product (id, product_name, description, price, weight, brand_id, organic, image_url) VALUES
                                                                                                     (1, 'Coca-Cola Classic 1.5L',          'Originele Coca-Cola frisdrank',                2.19, 1.5,   1, false, '/img/1.png'),
                                                                                                     (2, 'Coca-Cola Zero Sugar 1.5L',       'Cola zonder suiker',                           2.19, 1.5,   1, false, '/img/2.png'),
                                                                                                     (3, 'KitKat 4 Finger',                 'Chocolade wafeltje',                           1.39, 0.045, 2, false, '/img/3.png'),
                                                                                                     (4, 'Nescafé Classic Instant Coffee',  'Rijke instantkoffie',                          5.49, 0.2,   2, false, '/img/4.png'),
                                                                                                     (5, 'Activia Natural Yogurt',          'Probiotische yoghurt voor de spijsvertering',  2.69, 0.5,   3, false, '/img/5.png'),
                                                                                                     (6, 'Danone Greek Style Yogurt',       'Romige Griekse yoghurt',                       2.49, 0.5,   3, false, '/img/6.png'),
                                                                                                     (7, 'Lay''s Classic Chips',            'Klassieke gezouten chips',                     2.79, 0.2,   4, false, '/img/7.png'),
                                                                                                     (8, 'Lay''s Paprika Chips',            'Chips met paprikasmaak',                       2.79, 0.2,   4, false, '/img/8.png'),
                                                                                                     (9, 'Heinz Tomato Ketchup',            'Klassieke tomatenketchup',                     3.69, 0.5,   5, false, '/img/9.png'),
                                                                                                     (10,'Heinz Organic Tomato Ketchup',    'Biologische tomatenketchup',                   4.49, 0.5,   5, true,  '/img/10.png');

INSERT INTO product_categories (products_id, categories_id) VALUES
-- DRANK
(1, 1),
(2, 1),
(4, 1),
-- SNACKS
(3, 2),
(7, 2),
(8, 2),
-- ZUIVEL
(5, 3),
(6, 3),
-- SAUZEN
(9, 4),
(10, 4),
-- SUPER DEALS
(2, 5),
(3, 5),
(7, 5),
-- NIEUWKOMERS
(6, 6),
(8, 6),
(10, 6),
-- BESTSELLERS
(1, 7),
(3, 7),
(7, 7),
(9, 7);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('admin', '$2a$10$Ep8C1RWaVSIEGKwVoaIq3O895sGAAtnfruDVWORXWHg/jNYdR696a', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES ('admin', 'ADMIN');