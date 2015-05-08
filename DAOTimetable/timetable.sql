-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 09 2015 г., 01:23
-- Версия сервера: 5.6.21
-- Версия PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `timetable`
--

-- --------------------------------------------------------

--
-- Структура таблицы `lecturer`
--

CREATE TABLE IF NOT EXISTS `lecturer` (
`lect_id` int(5) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `subj_id` int(5) NOT NULL,
  `lectures_num` int(11) NOT NULL,
  `students_num` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lecturer`
--

INSERT INTO `lecturer` (`lect_id`, `fullname`, `subj_id`, `lectures_num`, `students_num`) VALUES
(1, 'Ivanov Ivan', 2, 205, 30),
(2, 'Petrov', 4, 509, 20),
(3, 'Emelianov', 3, 303, 23);

-- --------------------------------------------------------

--
-- Структура таблицы `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `subj_id` int(5) NOT NULL DEFAULT '0',
  `title` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `class` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `subject`
--

INSERT INTO `subject` (`subj_id`, `title`, `date`, `class`) VALUES
(2, 'informatic', '2015-04-06', 205),
(3, 'OOP', '2015-06-06', 301),
(4, 'Java', '2015-12-06', 341),
(5, 'Fizix', '2015-11-26', 107),
(6, 'Fizix', '2014-11-26', 207),
(7, 'Math', '2015-11-16', 217),
(9, 'Parsers', '2015-06-06', 308);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `lecturer`
--
ALTER TABLE `lecturer`
 ADD PRIMARY KEY (`lect_id`);

--
-- Индексы таблицы `subject`
--
ALTER TABLE `subject`
 ADD PRIMARY KEY (`subj_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `lecturer`
--
ALTER TABLE `lecturer`
MODIFY `lect_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
