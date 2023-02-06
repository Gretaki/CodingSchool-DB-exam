insert into participant (id, name) values (1, 'Rustie'),
(2, 'Tremayne'),
(3, 'Bonnibelle'),
(4, 'Kevan'),
(5, 'Devonna'),
(6, 'Doloritas'),
(7, 'Dietrich'),
(8, 'Homere'),
(9, 'Issy'),
(10, 'Aarika');

insert into exam (id, name) values (1, 'Services'),
(2, 'Support'),
(3, 'Services'),
(4, 'Training'),
(5, 'Product Management');

insert into question (id, question, exam_id) values (1, 'Function-based dedicated circuit?', 1),
(2, 'Mandatory even-keeled application?', 1),
(3, 'Intuitive incremental definition?', 1),
(4, 'Innovative maximized structure?', 1),
(5, 'Intuitive multi-tasking contingency?', 1),
(6, 'Managed local Graphic Interface?', 1),
(7, 'Exclusive non-volatile budgetary management?', 1),
(8, 'Extended explicit collaboration?', 1),
(9, 'Right-sized 24/7 standardization?', 1),
(10, 'Managed tangible conglomeration?', 1),
(11, 'Multi-channelled 4th generation throughput?', 2),
(12, 'Visionary user-facing system engine?', 2),
(13, 'Customizable homogeneous alliance?', 2),
(14, 'Ergonomic object-oriented system engine?', 2),
(15, 'Distributed hybrid task-force?', 2),
(16, 'Programmable mobile concept?', 2),
(17, 'Diverse even-keeled protocol?', 2),
(18, 'Front-line web-enabled capability?', 2),
(19, 'Streamlined encompassing local area network?', 2),
(20, 'Synergistic contextually-based time-frame?', 2),
(21, 'Horizontal tangible circuit?', 3),
(22, 'Enhanced discrete interface?', 3),
(23, 'Exclusive actuating flexibility?', 3),
(24, 'Expanded upward-trending orchestration?', 3),
(25, 'Monitored 3rd generation superstructure?', 3),
(26, 'Multi-channelled empowering focus group?', 3),
(27, 'Ergonomic fault-tolerant help-desk?', 3),
(28, 'Networked client-driven monitoring?', 3),
(29, 'Virtual 5th generation success?', 3),
(30, 'Streamlined analyzing success?', 3),
(31, 'Integrated foreground alliance?', 4),
(32, 'Cross-platform hybrid task-force?', 4),
(33, 'Visionary even-keeled groupware?', 4),
(34, 'Devolved dedicated workforce?', 4),
(35, 'Diverse actuating archive?', 4),
(36, 'Cloned tertiary emulation?', 4),
(37, 'Integrated next generation hierarchy?', 4),
(38, 'Grass-roots heuristic algorithm?', 4),
(39, 'Triple-buffered empowering array?', 4),
(40, 'Cross-platform composite service-desk?', 4),
(41, 'Intuitive empowering knowledge base?', 5),
(42, 'Ergonomic asymmetric policy?', 5),
(43, 'Stand-alone system-worthy contingency?', 5),
(44, 'Advanced exuding Graphic Interface?', 5),
(45, 'Diverse multi-tasking challenge?', 5),
(46, 'Pre-emptive executive function?', 5),
(47, 'Centralized disintermediate conglomeration?', 5),
(48, 'Programmable upward-trending knowledge base?', 5),
(49, 'Mandatory zero tolerance task-force?', 5),
(50, 'Horizontal clear-thinking task-force?', 5);

insert into answer (id, answer, answer_is_correct, question_id) values (1, 'Universal', 1, 1),
(2, 'real-time', 0, 1),
(3, 'Progressive', 0, 1),
(4, 'Persistent', 0, 2),
(5, 'methodical', 1, 2),
(6, 'implementation', 0, 2),
(7, 'strategy', 0, 3),
(8, 'Quality-focused', 0, 3),
(9, 'Cross-group', 1, 3),
(10, 'contextually-based', 1, 4),
(11, 'task-force', 0, 4),
(12, 'motivating', 0, 4),
(13, 'forecast', 0, 5),
(14, 'Optimized', 1, 5),
(15, 'process improvement', 0, 5),
(16, 'capability', 0, 6),
(17, 'moratorium', 0, 6),
(18, 'synergy', 1, 6),
(19, 'Seamless', 1, 7),
(20, 'algorithm', 0, 7),
(21, 'solution-oriented', 0, 7),
(22, '24/7', 0, 8),
(23, 'definition', 1, 8),
(24, 'toolset', 0, 8),
(25, 'Advanced', 0, 9),
(26, 'Object-based', 0, 9),
(27, 'motivating', 1, 9),
(28, 'function', 1, 10),
(29, 'modular', 0, 10),
(30, 'executive', 0, 10),
(31, 'content-based', 0, 11),
(32, 'knowledge base', 1, 11),
(33, 'real-time', 0, 11),
(34, 'foreground', 0, 12),
(35, 'Secured', 0, 12),
(36, 'Intuitive', 1, 12),
(37, 'access', 1, 13),
(38, 'structure', 0, 13),
(39, 'budgetary management', 0, 13),
(40, 'web-enabled', 0, 14),
(41, 'website', 1, 14),
(42, 'Multi-tiered', 0, 14),
(43, 'moratorium', 0, 15),
(44, 'mission-critical', 0, 15),
(45, 'motivating', 1, 15),
(46, 'hardware', 1, 16),
(47, 'Horizontal', 0, 16),
(48, '6th generation', 0, 16),
(49, 'De-engineered', 0, 17),
(50, '5th generation', 1, 17),
(51, 'asymmetric', 0, 17),
(52, 'policy', 0, 18),
(53, 'Customer-focused', 0, 18),
(54, 'Reactive', 1, 18),
(55, 'Universal', 1, 19),
(56, 'cohesive', 0, 19),
(57, 'Synergized', 0, 19),
(58, 'Down-sized', 0, 20),
(59, 'Pre-emptive', 1, 20),
(60, 'demand-driven', 0, 20),
(61, 'stable', 0, 21),
(62, 'demand-driven', 0, 21),
(63, 'function', 1, 21),
(64, 'success', 1, 22),
(65, 'archive', 0, 22),
(66, 'optimal', 0, 22),
(67, 'contingency', 0, 23),
(68, 'Public-key', 1, 23),
(69, 'radical', 0, 23),
(70, 'directional', 0, 24),
(71, 'cohesive', 0, 24),
(72, 'background', 1, 24),
(73, 'Reduced', 1, 25),
(74, 'workforce', 0, 25),
(75, 'process improvement', 0, 25),
(76, 'Stand-alone', 0, 26),
(77, 'knowledge base', 1, 26),
(78, 'framework', 0, 26),
(79, 'Polarised', 0, 27),
(80, 'algorithm', 0, 27),
(81, 'alliance', 1, 27),
(82, 'parallelism', 1, 28),
(83, 'Fully-configurable', 0, 28),
(84, 'attitude', 0, 28),
(85, 'scalable', 0, 29),
(86, 'Total', 1, 29),
(87, 'Proactive', 0, 29),
(88, 'Virtual', 0, 30),
(89, 'reciprocal', 0, 30),
(90, 'policy', 1, 30),
(91, 'Sharable', 1, 31),
(92, 'impactful', 0, 31),
(93, 'Secured', 0, 31),
(94, 'explicit', 0, 32),
(95, 'optimizing', 1, 32),
(96, 'global', 0, 32),
(97, 'success', 0, 33),
(98, 'process improvement', 0, 33),
(99, 'Total', 1, 33),
(100, 'Optimized', 1, 34),
(101, 'client-driven', 0, 34),
(102, 'Secured', 0, 34),
(103, 'ability', 0, 35),
(104, 'non-volatile', 1, 35),
(105, '5th generation', 0, 35),
(106, 'matrices', 0, 36),
(107, 'bandwidth-monitored', 0, 36),
(108, 'transitional', 1, 36),
(109, 'Customer-focused', 1, 37),
(110, 'capability', 0, 37),
(111, 'User-centric', 0, 37),
(112, 'holistic', 0, 38),
(113, 'Vision-oriented', 1, 38),
(114, 'array', 0, 38),
(115, 'Diverse', 0, 39),
(116, 'responsive', 0, 39),
(117, 'optimizing', 1, 39),
(118, '5th generation', 1, 40),
(119, 'matrix', 0, 40),
(120, 'Universal', 0, 40),
(121, 'scalable', 0, 41),
(122, '24/7', 1, 41),
(123, 'Switchable', 0, 41),
(124, 'Universal', 0, 42),
(125, 'bottom-line', 0, 42),
(126, 'Fundamental', 1, 42),
(127, 'zero defect', 1, 43),
(128, 'mission-critical', 0, 43),
(129, 'executive', 0, 43),
(130, 'clear-thinking', 0, 44),
(131, 'website', 1, 44),
(132, 'upward-trending', 0, 44),
(133, 'definition', 0, 45),
(134, 'adapter', 0, 45),
(135, 'Secured', 1, 45),
(136, 'Front-line', 1, 46),
(137, 'open architecture', 0, 46),
(138, 'Versatile', 0, 46),
(139, 'structure', 0, 47),
(140, 'client-driven', 1, 47),
(141, 'service-desk', 0, 47),
(142, 'Synchronised', 0, 48),
(143, 'tangible', 0, 48),
(144, 'Quality-focused', 1, 48),
(145, 'Reverse-engineered', 1, 49),
(146, 'model', 0, 49),
(147, 'Graphic Interface', 0, 49),
(148, 'emulation', 0, 50),
(149, 'hub', 1, 50),
(150, 'Expanded', 0, 50);

insert into result (id, status, exam_id, participant_id) values (1, 1, 1, 1),
(2, 0, 1, 2),
(3, 1, 1, 3),
(4, 1, 1, 4),
(5, 1, 1, 5),
(6, 1, 1, 6),
(7, 1, 2, 1),
(8, 1, 2, 2),
(9, 1, 2, 3),
(10, 0, 3, 1),
(11, 0, 3, 2),
(12, 0, 3, 3),
(13, 0, 3, 7),
(14, 1, 3, 8),
(15, 1, 3, 9);

INSERT INTO result_choice (id, answer_id, question_id, result_id) VALUES
(1, 3, 1, 1),
(2, 4, 2, 1),
(3, 7, 3, 1),
(4, 10, 4, 1),
(5, 14, 5, 1),
(6, 16, 6, 1),
(7, 19, 7, 1),
(8, 22, 8, 1),
(9, 26, 9, 1),
(10, 30, 10, 1),
(11, 1, 1, 2),
(12, 4, 2, 2),
(13, 7, 3, 2),
(14, 11, 4, 2),
(15, 14, 5, 2),
(16, 17, 6, 2),
(17, 20, 7, 2),
(18, 22, 8, 2),
(19, 25, 9, 2),
(20, 29, 10, 2),
(21, 3, 1, 3),
(22, 4, 2, 3),
(23, 7, 3, 3),
(24, 10, 4, 3),
(25, 13, 5, 3),
(26, 16, 6, 3),
(27, 21, 7, 3),
(28, 23, 8, 3),
(29, 27, 9, 3),
(30, 29, 10, 3),
(31, 2, 1, 4),
(32, 4, 2, 4),
(33, 9, 3, 4),
(34, 11, 4, 4),
(35, 13, 5, 4),
(36, 16, 6, 4),
(37, 20, 7, 4),
(38, 23, 8, 4),
(39, 26, 9, 4),
(40, 28, 10, 4),
(41, 2, 1, 5),
(42, 5, 2, 5),
(43, 7, 3, 5),
(44, 12, 4, 5),
(45, 13, 5, 5),
(46, 17, 6, 5),
(47, 21, 7, 5),
(48, 22, 8, 5),
(49, 25, 9, 5),
(50, 29, 10, 5),
(51, 2, 1, 6),
(52, 5, 2, 6),
(53, 7, 3, 6),
(54, 12, 4, 6),
(55, 14, 5, 6),
(56, 16, 6, 6),
(57, 20, 7, 6),
(58, 24, 8, 6),
(59, 25, 9, 6),
(60, 30, 10, 6),
(61, 32, 11, 7),
(62, 35, 12, 7),
(63, 39, 13, 7),
(64, 41, 14, 7),
(65, 44, 15, 7),
(66, 47, 16, 7),
(67, 51, 17, 7),
(68, 52, 18, 7),
(69, 57, 19, 7),
(70, 58, 20, 7),
(71, 31, 11, 8),
(72, 34, 12, 8),
(73, 38, 13, 8),
(74, 40, 14, 8),
(75, 44, 15, 8),
(76, 46, 16, 8),
(77, 50, 17, 8),
(78, 54, 18, 8),
(79, 57, 19, 8),
(80, 59, 20, 8),
(81, 31, 11, 9),
(82, 34, 12, 9),
(83, 37, 13, 9),
(84, 41, 14, 9),
(85, 43, 15, 9),
(86, 46, 16, 9),
(87, 50, 17, 9),
(88, 52, 18, 9),
(89, 57, 19, 9),
(90, 60, 20, 9),
(91, 61, 21, 10),
(92, 66, 22, 10),
(93, 68, 23, 10),
(94, 71, 24, 10),
(95, 74, 25, 10),
(96, 76, 26, 10),
(97, 80, 27, 10),
(98, 83, 28, 10),
(99, 85, 29, 10),
(100, 90, 30, 10),
(101, 62, 21, 11),
(102, 65, 22, 11),
(103, 67, 23, 11),
(104, 71, 24, 11),
(105, 75, 25, 11),
(106, 76, 26, 11),
(107, 80, 27, 11),
(108, 82, 28, 11),
(109, 87, 29, 11),
(110, 89, 30, 11),
(111, 63, 21, 12),
(112, 66, 22, 12),
(113, 67, 23, 12),
(114, 72, 24, 12),
(115, 75, 25, 12),
(116, 76, 26, 12),
(117, 80, 27, 12),
(118, 84, 28, 12),
(119, 87, 29, 12),
(120, 88, 30, 12),
(121, 62, 21, 13),
(122, 64, 22, 13),
(123, 68, 23, 13),
(124, 72, 24, 13),
(125, 74, 25, 13),
(126, 76, 26, 13),
(127, 80, 27, 13),
(128, 84, 28, 13),
(129, 85, 29, 13),
(130, 90, 30, 13),
(131, 63, 21, 14),
(132, 64, 22, 14),
(133, 69, 23, 14),
(134, 70, 24, 14),
(135, 73, 25, 14),
(136, 76, 26, 14),
(137, 79, 27, 14),
(138, 84, 28, 14),
(139, 86, 29, 14),
(140, 88, 30, 14),
(141, 61, 21, 15),
(142, 64, 22, 15),
(143, 67, 23, 15),
(144, 71, 24, 15),
(145, 74, 25, 15),
(146, 76, 26, 15),
(147, 81, 27, 15),
(148, 84, 28, 15),
(149, 87, 29, 15),
(150, 89, 30, 15);


select exam.id, name, count(result.id) from exam left join result on exam.id = result.exam_id group by exam.id, name;

select e.id, name, count(distinct(r.participant_id)), sum(a.answer_is_correct) correct, count(a.id) total from exam e
left join result r on e.id = r.exam_id 
join result_choice rc on r.id = rc.result_id 
join answer a on rc.answer_id = a.id
where r.status = 1
group by e.id, name;

select  q.id, q.question, 
count(case when (a.id - 3 * (q.id - 1) = 1) then 1 end ) as '1',
count(case when (a.id - 3 * (q.id - 1) = 2) then 1 end ) as '2',
count(case when (a.id - 3 * (q.id - 1) = 3) then 1 end ) as '3' 
from result_choice rc
join question q on rc.question_id = q.id
 join answer a on rc.answer_id = a.id
 group by q.id, q.question;

select answer_id, question_id, count(answer_id) from result_choice
group by answer_id, question_id;
