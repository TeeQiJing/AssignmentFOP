-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2023 at 03:28 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `codefornature`
--

-- --------------------------------------------------------

--
-- Table structure for table `home`
--

CREATE TABLE `home` (
  `email` varchar(255) NOT NULL,
  `checked` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `home`
--

INSERT INTO `home` (`email`, `checked`, `date`) VALUES
('bobby123@gmail.com', '2023-12-18', '2023-12-18'),
('lauduanhang@gmail.com', '2023-12-18', '2023-12-18'),
('qibin041227@gmail.com', '2023-12-18', '2023-12-18'),
('qijingtee1227@gmail.com', '2023-12-18', '2023-12-18'),
('sasa@gmail.com', '2023-12-18', '2023-12-18'),
('test123@gmail.com', '2023-12-18', '2023-12-18'),
('zhenyu123@gmail.com', '2023-12-18', '2023-12-18');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `title` text NOT NULL,
  `url` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`title`, `url`, `date`) VALUES
('How the war changed Russia’s climate agenda', 'https://bbc.com/news/world-europe-67637803', '2023-12-10'),
('How divers are using antibiotics to save a massive coral reef', 'https://bbc.com/news/world-latin-america-67647402', '2023-12-10'),
('Cornish company wins top environmental award', 'https://bbc.com/news/uk-england-cornwall-67637023', '2023-12-09'),
('Part of sea wall removed to help saltmarsh', 'https://bbc.com/news/uk-england-essex-67659934', '2023-12-09'),
('Homes get free hot water from computer heat', 'https://bbc.com/news/uk-england-surrey-67590284', '2023-12-08'),
('Gas smell over Teesside being investigated', 'https://bbc.com/news/uk-england-tees-67654895', '2023-12-08'),
('Heavy rains leave trail of destruction in Indian city', 'https://bbc.com/news/world-asia-india-67645286', '2023-12-07'),
('Condoms, tampons and wipes washing up on beach', 'https://bbc.com/news/uk-england-tees-67630378', '2023-12-07'),
('Cycle bridge installed over A30 at Chiverton', 'https://bbc.com/news/uk-england-cornwall-67640749', '2023-12-06'),
('\'Depressing\' to find disposable vapes on riverbed', 'https://bbc.com/news/uk-england-wiltshire-67636437', '2023-12-06'),
('Olive oil price skyrockets as Spanish drought bites', 'https://bbc.com/news/world-europe-67565503', '2023-12-06'),
('Over 200 areas missing out on benefits of trees', 'https://bbc.com/news/uk-northern-ireland-67617106', '2023-12-05'),
('\'Protecting the Earth is a religious duty\'', 'https://bbc.com/news/newsbeat-67581447', '2023-12-04'),
('Housing development worth £33.5m approved', 'https://bbc.com/news/uk-england-devon-67615445', '2023-12-04'),
('Panel proposed to plant trees after Storm Ciarán', 'https://bbc.com/news/articles/cqepdlz5mrjo', '2023-12-04'),
('How scientists are fighting climate-fuelled disease', 'https://bbc.com/news/science-environment-67591422', '2023-12-03'),
('Nuclear plant \'building relationships\' through arts', 'https://bbc.com/news/articles/ckkppl1pd40o', '2023-12-02'),
('Peru environmentalist who fought for Amazon killed', 'https://bbc.com/news/world-latin-america-67597566', '2023-12-02'),
('Group wants to save land being sold by tyre company', 'https://bbc.com/news/uk-england-wiltshire-67591898', '2023-12-01'),
('Paths reopen as storm clear-up continues', 'https://bbc.com/news/articles/cn0pp5g0jdno', '2023-12-01'),
('Firm\'s £1m charities donation over water pollution', 'https://bbc.com/news/uk-england-york-north-yorkshire-67564782', '2023-11-30'),
('UK\'s last opencast coal mine shuts after legal row', 'https://bbc.com/news/uk-wales-67564413', '2023-11-30'),
('How \'rat-hole\' miners freed Indian tunnel workers', 'https://bbc.com/news/world-asia-india-67563247', '2023-11-29'),
('British Sugar invests £16.5m in evaporation plant', 'https://bbc.com/news/articles/cpep8q210kko', '2023-11-29'),
('Each Bitcoin payment \'uses a swimming pool of water\'', 'https://bbc.com/news/technology-67564205', '2023-11-29'),
('Panama orders controversial copper mine\'s closure', 'https://bbc.com/news/world-latin-america-67565315', '2023-11-29'),
('41 men trapped for 17 days: India\'s stark wake-up call', 'https://bbc.com/news/world-asia-india-67529337', '2023-11-27'),
('New forest will be planted in Tees Valley by 2025', 'https://bbc.com/news/uk-england-tees-67545941', '2023-11-27'),
('Link road cost rises to £274m', 'https://bbc.com/news/uk-england-norfolk-67525759', '2023-11-27'),
('Beach gets green light after sewage plant spillage', 'https://bbc.com/news/articles/cd1pzr4nex7o', '2023-11-27'),
('Protesters say Lough Neagh problems \'not over\'', 'https://bbc.com/news/uk-northern-ireland-67538417', '2023-11-26'),
('Projects to remove chemicals from rivers underway', 'https://bbc.com/news/articles/c72q19xn35yo', '2023-11-26'),
('Repairs planned for Devil\'s Point tidal pool', 'https://bbc.com/news/uk-england-devon-67485472', '2023-11-26'),
('Why are peatlands important for the environment?', 'https://bbc.com/news/uk-northern-ireland-67523854', '2023-11-25'),
('Council\'s public plea over climate change strategy', 'https://bbc.com/news/uk-england-leicestershire-67515490', '2023-11-24'),
('\'I stopped buying new clothes when I was a child\'', 'https://bbc.com/news/uk-england-hampshire-67497781', '2023-11-24'),
('Watch: Five top tips for thrifting. Video, 00:00:32 Watch: Five top tips for thrifting', 'https://bbc.com/news/uk-england-hampshire-67511694', '2023-11-24'),
('Council gives away free EV charging in IT error', 'https://bbc.com/news/uk-england-surrey-67499892', '2023-11-23'),
('Blue whales return to \'safe\' tropical haven', 'https://bbc.com/news/science-environment-67496339', '2023-11-23'),
('Rescuers close in on trapped Indian tunnel workers', 'https://bbc.com/news/world-asia-india-67493740', '2023-11-22'),
('Flood-hit primary school gets £450k defences', 'https://bbc.com/news/uk-england-leeds-67499035', '2023-11-22'),
('RSPCA says it is bracing for a crisis winter', 'https://bbc.com/news/articles/c062p86465jo', '2023-11-22'),
('Climate advisers warn of \'damaging cascading impacts\'', 'https://bbc.com/news/articles/c0x2d839e1lo', '2023-11-22'),
('Warning as treated sewage pours into sea', 'https://bbc.com/news/articles/clmp92dj2l1o', '2023-11-22'),
('PM defends \'severe\' Just Stop Oil sentences', 'https://bbc.com/news/articles/c6pxn4z1rqno', '2023-11-21'),
('‘Stressed jellyfish’ reveal dangers of seabed mining', 'https://bbc.com/news/science-environment-67486365', '2023-11-21'),
('Parental car ban from school area made permanent', 'https://bbc.com/news/uk-england-tyne-67485649', '2023-11-21'),
('UN criticises \'severe\' Just Stop Oil sentences', 'https://bbc.com/news/articles/cn0p6ll3jjgo', '2023-11-21'),
('Wye salmon faces extinction in 6 years - campaigners', 'https://bbc.com/news/articles/c889d8ykredo', '2023-11-20'),
('What does council\'s zero carbon home plan mean? Video, 00:00:48 What does council\'s zero carbon home plan mean?', 'https://bbc.com/news/uk-england-oxfordshire-67438972', '2023-11-20'),
('Fishing industry warns against cuttlefish size rules', 'https://bbc.com/news/articles/c0w2rqpq3k0o', '2023-11-19'),
('Lough algae \'still loitering\' and impact unknown', 'https://bbc.com/news/uk-northern-ireland-67308758', '2023-11-18'),
('Wild swimmers at lake committing trespass - council', 'https://bbc.com/news/articles/c843p2y51plo', '2023-11-17'),
('Kenya\'s President Ruto named global climate leader', 'https://bbc.com/news/world-africa-67447481', '2023-11-17'),
('Pair of swan sweethearts make latest UK return', 'https://bbc.com/news/science-environment-67407574', '2023-11-17'),
('City centre reed beds could ease sewage in sea', 'https://bbc.com/news/articles/c032703760qo', '2023-11-16'),
('Sand lizards return to heath after fire', 'https://bbc.com/news/articles/c2l2q97jgypo', '2023-11-16'),
('Activists fear wildlife impact of electricity line', 'https://bbc.com/news/uk-england-kent-67415457', '2023-11-15'),
('Therese Coffey \'nearly died\' due to minister stress', 'https://bbc.com/news/uk-england-suffolk-67415285', '2023-11-14'),
('Tree preservation order \'will benefit ecology\'', 'https://bbc.com/news/articles/clwpjww492do', '2023-11-14'),
('Meadow restoration aims to boost biodiversity', 'https://bbc.com/news/uk-england-somerset-67373719', '2023-11-13'),
('Repairs begin to promenade damaged by storms', 'https://bbc.com/news/uk-england-tyne-67396083', '2023-11-12'),
('Plans to plant new \'community forest\'', 'https://bbc.com/news/uk-england-cumbria-67382134', '2023-11-12'),
('New 315-panel solar carport unveiled in Plymouth', 'https://bbc.com/news/uk-england-devon-67379785', '2023-11-11'),
('Asia leads way in Earthshot quest to repair planet', 'https://bbc.com/news/world-asia-67353689', '2023-11-11'),
('Estuary flood and wildlife scheme launched', 'https://bbc.com/news/uk-england-tees-67372146', '2023-11-09'),
('Illegal sewage spills inevitable, says Dŵr Cymru', 'https://bbc.com/news/uk-wales-politics-67360894', '2023-11-09'),
('Prince William reveals five Earthshot Prize winners', 'https://bbc.com/news/world-asia-67334918', '2023-11-07'),
('Coca-Cola and Nestle accused of misleading eco claims', 'https://bbc.com/news/business-67343893', '2023-11-07'),
('Watch: William on \'positive impact\' of Earthshot Prize. Video, 00:00:45 Watch: William on \'positive impact\' of Earthshot Prize', 'https://bbc.com/news/uk-67342747', '2023-11-07'),
('Plan for annual North Sea oil and gas licences', 'https://bbc.com/news/uk-politics-67326497', '2023-11-06'),
('Wild swimmers apply for special status for river spot', 'https://bbc.com/news/uk-england-somerset-67262149', '2023-11-04'),
('Shellfish die-off: Tests agree with prior study', 'https://bbc.com/news/uk-england-tees-67310414', '2023-11-03'),
('City\'s air quality plan hit by further delays', 'https://bbc.com/news/uk-england-hereford-worcester-67309366', '2023-11-03'),
('University gets £21m grant to decarbonise campus', 'https://bbc.com/news/uk-england-lancashire-67308213', '2023-11-03'),
('Steelworkers may ballot to strike over Tata plans', 'https://bbc.com/news/uk-wales-67307014', '2023-11-03'),
('Tech promises to remove the guesswork from fishing', 'https://bbc.com/news/technology-67093211', '2023-11-03'),
('More than 300 streetlights not working on busy road', 'https://bbc.com/news/uk-england-essex-67290639', '2023-11-02'),
('What are the arguments for and against Sizewell C?', 'https://bbc.com/news/uk-england-suffolk-62035444', '2023-11-02'),
('No legal cases over protected trees being cut down', 'https://bbc.com/news/uk-northern-ireland-67290662', '2023-11-02'),
('Council electric vehicles arrive to cut emissions', 'https://bbc.com/news/uk-england-manchester-67284098', '2023-11-01'),
('\'We failed - why our dream eco-business collapsed\'', 'https://bbc.com/news/business-66935496', '2023-11-01'),
('Heathrow plans cause environmental fears for park', 'https://bbc.com/news/articles/c51vne534v4o', '2023-10-30'),
('What will plastic ban mean for takeaway prices?', 'https://bbc.com/news/uk-wales-67238310', '2023-10-30'),
('The man rescuing Britain\'s \'magical\' glow worms', 'https://bbc.com/news/science-environment-67240450', '2023-10-28'),
('Thousands sign petition against felling trees', 'https://bbc.com/news/uk-england-tyne-67219758', '2023-10-25'),
('Dark times as Game of Thrones trees face axe', 'https://bbc.com/news/uk-northern-ireland-67215059', '2023-10-25'),
('Day aims to show children \'green is exciting\'', 'https://bbc.com/news/uk-england-suffolk-67209239', '2023-10-25'),
('Local anglers say fish kill \'probably worst ever\'', 'https://bbc.com/news/uk-northern-ireland-67199706', '2023-10-24'),
('Change to historic ponds dismissed over flood risk', 'https://bbc.com/news/uk-england-gloucestershire-67206419', '2023-10-24'),
('Angler refuses to pay bills in sewage protest', 'https://bbc.com/news/articles/ckrepj48vx9o', '2023-10-23'),
('Infected trees beauty spot stays open to visitors', 'https://bbc.com/news/uk-wales-67191982', '2023-10-23'),
('Residents fear ex-landfill site could be leaking', 'https://bbc.com/news/articles/cye13rdn36po', '2023-10-23'),
('No flushing plea after clothes block drains', 'https://bbc.com/news/world-europe-guernsey-67175207', '2023-10-23'),
('Ice rink to be run by biofuel generators', 'https://bbc.com/news/uk-england-gloucestershire-67187576', '2023-10-22'),
('Steely gaze of endangered tigress tops mangrove photo awards', 'https://bbc.com/news/in-pictures-67155632', '2023-10-22'),
('Can the UK\'s tides help wean us off fossil fuels?', 'https://bbc.com/news/science-environment-67170625', '2023-10-22'),
('Rally hears calls for urgent action on Lough Neagh', 'https://bbc.com/news/uk-northern-ireland-67183340', '2023-10-21'),
('Wetlands conservation charity scoops £20k grant', 'https://bbc.com/news/uk-england-gloucestershire-67145394', '2023-10-21'),
('Rescue mission for UK rainforests’ weird treasures', 'https://bbc.com/news/science-environment-66989115', '2023-10-21'),
('Multiple factors caused Hastings floods - report', 'https://bbc.com/news/articles/cd1lz8gjdn9o', '2023-10-20'),
('Judicial review granted over River Wye pollution', 'https://bbc.com/news/uk-england-hereford-worcester-67165280', '2023-10-20'),
('Endangered monkey born in County Donegal', 'https://bbc.com/news/articles/cxrvld0pvplo', '2023-10-20'),
('Council criticises \'lazy\' fly-tippers after clean-up', 'https://bbc.com/news/uk-england-tees-67163472', '2023-10-19'),
('Water firm admits years of illegal sewage spills', 'https://bbc.com/news/science-environment-67077510', '2023-10-19'),
('First oysters introduced to island\'s harbour', 'https://bbc.com/news/articles/c6pk7ep420zo', '2023-10-19'),
('Single-use plastic ban brought in for Manx firms', 'https://bbc.com/news/world-europe-isle-of-man-67104273', '2023-10-19'),
('Campaigners attack MP over link road support', 'https://bbc.com/news/uk-england-norfolk-67144627', '2023-10-19'),
('Ferrets in firing line as island traps activated', 'https://bbc.com/news/uk-northern-ireland-67139043', '2023-10-18'),
('Boiler firm to be investigated over \'green\' claims', 'https://bbc.com/news/uk-england-hereford-worcester-67138049', '2023-10-17'),
('Attenborough series returns to green turtles after 66 years. Video, 00:01:31 Attenborough series returns to green turtles after 66 years', 'https://bbc.com/news/science-environment-67093898', '2023-10-16'),
('\'Time for change\' in push for cleaner rivers', 'https://bbc.com/news/uk-england-devon-66928936', '2023-10-16'),
('Record-breaking swimmer joins sewage protest', 'https://bbc.com/news/uk-england-lancashire-67112786', '2023-10-14'),
('Norfolk coast to receive £25m sea defences boost', 'https://bbc.com/news/uk-england-norfolk-67101508', '2023-10-13'),
('Why this fisherman refuses to keep his catch', 'https://bbc.com/news/uk-wales-67083525', '2023-10-12'),
('£3m plan for new electric vehicle charging points', 'https://bbc.com/news/uk-england-northamptonshire-67078864', '2023-10-11'),
('Campaigners celebrate victory in tree battle', 'https://bbc.com/news/uk-england-northamptonshire-67070380', '2023-10-11'),
('Plans resubmitted for spa hotel in country park', 'https://bbc.com/news/uk-england-kent-67057824', '2023-10-10'),
('Sustainable Fashion Week makes global impact', 'https://bbc.com/news/uk-england-bristol-67021441', '2023-10-08'),
('The \'white gold\' rush dividing communities', 'https://bbc.com/news/technology-67028209', '2023-10-08'),
('Politicians criticised over green plan \'cowardice\'', 'https://bbc.com/news/uk-england-cambridgeshire-66955893', '2023-10-07'),
('Mapping Northern Ireland\'s ever-changing coastline', 'https://bbc.com/news/uk-northern-ireland-67013271', '2023-10-06'),
('Crackdown on waste crime uncovers illegal dumps', 'https://bbc.com/news/uk-england-cumbria-67018287', '2023-10-06'),
('Godwit stuns experts with 2,000-mile round trip', 'https://bbc.com/news/uk-england-norfolk-67008557', '2023-10-04'),
('Will the Earl of Shaftesbury sell Lough Neagh?', 'https://bbc.com/news/uk-northern-ireland-66996132', '2023-10-04'),
('Pope warns world \'collapsing\' due to climate change', 'https://bbc.com/news/world-67005362', '2023-10-04'),
('Earl open to sell Lough Neagh but not for free. Video, 00:00:59 Earl open to sell Lough Neagh but not for free', 'https://bbc.com/news/uk-northern-ireland-67006058', '2023-10-04'),
('Why is the UK\'s largest lake turning toxic green? Video, 00:01:53 Why is the UK\'s largest lake turning toxic green?', 'https://bbc.com/news/uk-northern-ireland-66998508', '2023-10-04'),
('Lough Neagh swimming could return this winter', 'https://bbc.com/news/uk-northern-ireland-66999463', '2023-10-04'),
('Wildlife trust launches \'nature recovery\' appeal', 'https://bbc.com/news/uk-england-oxfordshire-66987289', '2023-10-04'),
('What does the future hold for Lough Neagh?', 'https://bbc.com/news/uk-northern-ireland-66751451', '2023-10-03'),
('New trees help thousands access nature - trust', 'https://bbc.com/news/uk-england-merseyside-66987141', '2023-10-03'),
('Environment plan delayed by Stormont stalemate', 'https://bbc.com/news/uk-northern-ireland-66985286', '2023-10-02'),
('Choose Ludlow for green energy plant - councillor', 'https://bbc.com/news/uk-england-shropshire-66985210', '2023-10-02'),
('Fast-food shops facing restrictions near schools', 'https://bbc.com/news/uk-england-wiltshire-66961751', '2023-10-01'),
('Could the wolf return to Ireland\'s countryside?', 'https://bbc.com/news/articles/cgl39xvdnljo', '2023-10-01'),
('Ban on single-use plastic cutlery comes into force', 'https://bbc.com/news/uk-66974697', '2023-10-01'),
('Catastrophic floods devastate Greece\'s farmers', 'https://bbc.com/news/world-europe-66938011', '2023-09-30'),
('Trust hopes to buy \'scar on the landscape\' dyke', 'https://bbc.com/news/uk-england-cambridgeshire-66950685', '2023-09-29'),
('Some firms unaware of new single-use plastic ban', 'https://bbc.com/news/business-66946643', '2023-09-29'),
('River pollution results shocking, campaigners say', 'https://bbc.com/news/uk-england-norfolk-66949789', '2023-09-29'),
('The town caught up in a fly \'nightmare\'', 'https://bbc.com/news/uk-england-northamptonshire-66911971', '2023-09-29'),
('Work to create net-zero primary school begins', 'https://bbc.com/news/uk-england-somerset-66946933', '2023-09-29'),
('Pollution stopping bees finding flowers - study', 'https://bbc.com/news/uk-england-birmingham-66952926', '2023-09-28'),
('NI \'among world\'s most nature-depleted areas\'', 'https://bbc.com/news/uk-northern-ireland-66944701', '2023-09-28'),
('Marine wildlife warning as storms arrive', 'https://bbc.com/news/articles/cx0ek3052zdo', '2023-09-28'),
('Campaigners plan protest over town\'s air pollution', 'https://bbc.com/news/uk-england-northamptonshire-66939602', '2023-09-28'),
('Seabird numbers decline a \'wake-up call\'', 'https://bbc.com/news/uk-scotland-66939022', '2023-09-27'),
('UK \'dirty man\' after oil field approval - minister', 'https://bbc.com/news/uk-wales-politics-66939315', '2023-09-27'),
('Consultation amid low crab and lobster numbers', 'https://bbc.com/news/uk-england-cornwall-66912716', '2023-09-27'),
('How does the new 20mph speed limit law work?', 'https://bbc.com/news/uk-wales-62134399', '2023-09-26'),
('Hanner canrif o werthu cig yn Llanrug', 'https://bbc.com/cymrufyw/erthyglau/cq5lj4qjnrdo', '2023-09-26'),
('Unionists criticised over lough \'crisis\' motion', 'https://bbc.com/news/uk-northern-ireland-66923494', '2023-09-26'),
('Demolition begins at failed £800m waste factory', 'https://bbc.com/news/uk-england-essex-66895848', '2023-09-25'),
('The shadowy Chinese firms that own chunks of Cambodia', 'https://bbc.com/news/world-asia-66851049', '2023-09-25'),
('Algae map shows extent of Lough Neagh problems', 'https://bbc.com/news/uk-northern-ireland-66896942', '2023-09-23'),
('Blue-green algae confirmed at County Armagh lake', 'https://bbc.com/news/uk-northern-ireland-66896753', '2023-09-22'),
('River work branded \'environmental vandalism\'', 'https://bbc.com/news/uk-england-stoke-staffordshire-66893750', '2023-09-22'),
('Metal-mining pollution impacts 23 million people', 'https://bbc.com/news/science-environment-66880697', '2023-09-22'),
('Toxic blue-green algae confirmed at 65 locations', 'https://bbc.com/news/uk-northern-ireland-66883500', '2023-09-21'),
('Lack of post-Brexit environment watchdog criticised', 'https://bbc.com/news/uk-wales-politics-66881870', '2023-09-21'),
('Department in court over MOT diesel test claims', 'https://bbc.com/news/uk-northern-ireland-66876105', '2023-09-21'),
('\'Power up heat-pump scheme\' say manufacturers', 'https://bbc.com/news/uk-england-norfolk-66723928', '2023-09-21'),
('Rivers help chart London\'s pandemic health', 'https://bbc.com/news/uk-england-london-66868069', '2023-09-21'),
('We will hit net zero, says PM, after adviser criticises \'wishful thinking\'', 'https://bbc.com/news/live/uk-politics-66872792', '2023-09-21'),
('Lough Neagh \'should be treated as an emergency\'', 'https://bbc.com/news/uk-northern-ireland-66838618', '2023-09-20'),
('Cars, boilers and other key takeaways from Sunak\'s speech', 'https://bbc.com/news/uk-66871073', '2023-09-20'),
('Rishi Sunak pushes back ban on new petrol and diesel cars to 2035', 'https://bbc.com/news/live/uk-66863110', '2023-09-20'),
('Power imbalance: Is free electricity really fair?', 'https://bbc.com/news/uk-england-essex-66775731', '2023-09-20'),
('Calls for chalk streams legal protection', 'https://bbc.com/news/uk-england-hampshire-66853611', '2023-09-20'),
('William warns against \'doom and gloom\' on climate', 'https://bbc.com/news/uk-66859080', '2023-09-19'),
('SDLP bids to recall assembly over Lough Neagh', 'https://bbc.com/news/uk-northern-ireland-66838612', '2023-09-19'),
('Rewilding leads to bumper year for rare Kent moth', 'https://bbc.com/news/articles/cndejylzl8eo', '2023-09-18'),
('Mayor says Ulez possible as public \'educated\'', 'https://bbc.com/news/uk-england-london-66841678', '2023-09-18'),
('Protest highlights fears that \'lough is dying\'', 'https://bbc.com/news/uk-northern-ireland-66835897', '2023-09-17'),
('Wales first UK nation to drop speed limit to 20mph', 'https://bbc.com/news/uk-wales-66774379', '2023-09-17'),
('Antarctic ice at \'mind-blowing\' low alarms experts', 'https://bbc.com/news/science-environment-66724246', '2023-09-17'),
('Farmers feeling pressure of green subsidy delays', 'https://bbc.com/news/uk-england-coventry-warwickshire-66809337', '2023-09-15'),
('Thousands of roadside trees left to die, say Greens', 'https://bbc.com/news/uk-england-norfolk-66811388', '2023-09-15'),
('Charity loses bid to buy section of city woodland', 'https://bbc.com/news/uk-england-bristol-66811830', '2023-09-14'),
('England\'s rare species get £14.5m habitat boost', 'https://bbc.com/news/science-environment-66801439', '2023-09-14'),
('Campaigners secure \'litter summit\' with minister', 'https://bbc.com/news/uk-england-northamptonshire-66801481', '2023-09-14'),
('Millions in public money spent on illegal dump', 'https://bbc.com/news/uk-northern-ireland-66789885', '2023-09-13'),
('Colombia \'deadliest country for environmentalists\'', 'https://bbc.com/news/world-latin-america-66784686', '2023-09-13'),
('Government may have broken law over sewage - watchdog', 'https://bbc.com/news/science-environment-66778409', '2023-09-12'),
('Nature-friendly farming \'could be more profitable\'', 'https://bbc.com/news/uk-northern-ireland-66784076', '2023-09-12'),
('Litter-picking paddleboarders clean up beach', 'https://bbc.com/news/uk-england-tyne-66763203', '2023-09-09'),
('Urban oases combine roof gardens and solar panels', 'https://bbc.com/news/business-66054688', '2023-09-08'),
('Teams from UK learn to hunt hornets in Jersey', 'https://bbc.com/news/world-europe-jersey-66733187', '2023-09-07'),
('Green council aims to join climate network', 'https://bbc.com/news/articles/c97n9pl06zxo', '2023-09-06'),
('Suspected oil spill pollutes chalk stream river', 'https://bbc.com/news/uk-england-beds-bucks-herts-66723945', '2023-09-06'),
('Calls for action after BBC News report on sewage', 'https://bbc.com/news/science-environment-66717219', '2023-09-05'),
('Bereaved dad says everything he does is for daughter', 'https://bbc.com/news/uk-england-somerset-66715687', '2023-09-05'),
('UK bees in danger as Asian hornet sightings rise', 'https://bbc.com/news/science-environment-66697968', '2023-09-04'),
('RSPB boss sorry for post calling ministers \'liars\'', 'https://bbc.com/news/uk-politics-66666435', '2023-08-31'),
('Legal challenge to Larne Lough gas caverns fails', 'https://bbc.com/news/uk-northern-ireland-66671409', '2023-08-31'),
('The historic crop which could make fashion greener', 'https://bbc.com/news/uk-scotland-66593992', '2023-08-31'),
('Home of nature author up for sale for £1.5m', 'https://bbc.com/news/uk-england-suffolk-66664975', '2023-08-31'),
('Hundreds oppose possible tree felling at new estate', 'https://bbc.com/news/uk-england-northamptonshire-66661944', '2023-08-31'),
('Reviving the ancient craft of linen production in Scotland. Video, 00:01:19 Reviving the ancient craft of linen production in Scotland', 'https://bbc.com/news/uk-scotland-66660425', '2023-08-30'),
('Wildlife trust to fight water pollution rule changes', 'https://bbc.com/news/uk-england-norfolk-66652591', '2023-08-30'),
('Station lights brighter than town, campaigners say', 'https://bbc.com/news/uk-england-essex-66644730', '2023-08-30'),
('Work begins on flood prevention scheme', 'https://bbc.com/news/uk-england-cornwall-66618060', '2023-08-29'),
('Coal tip repairs threaten wildlife, ecologists say', 'https://bbc.com/news/uk-wales-66632770', '2023-08-29'),
('Tree map reveals island\'s green canopy', 'https://bbc.com/news/world-europe-jersey-66605736', '2023-08-28'),
('China’s summer of climate destruction', 'https://bbc.com/news/world-asia-china-66616699', '2023-08-28'),
('The indigenous groups fighting the quest for \'white gold\'', 'https://bbc.com/news/world-latin-america-66520097', '2023-08-27'),
('The indiscriminate devastation of Canada\'s wildfires', 'https://bbc.com/news/world-us-canada-66620230', '2023-08-27'),
('Dutch Grand Prix bans cars for fans in tiny coastal town', 'https://bbc.com/news/world-europe-66620698', '2023-08-26'),
('Fukushima: Why some scientists worry about water impact', 'https://bbc.com/news/world-asia-66610977', '2023-08-26'),
('Early blackberries sign of \'climate breakdown\' Video, 00:01:48 Early blackberries sign of \'climate breakdown\'', 'https://bbc.com/news/uk-england-devon-66597568', '2023-08-25'),
('Seal group urges beachgoers to ditch flying rings. Video, 00:01:20 Seal group urges beachgoers to ditch flying rings', 'https://bbc.com/news/uk-england-cornwall-66606489', '2023-08-25'),
('First breeding ospreys in Ireland for 200 years', 'https://bbc.com/news/uk-northern-ireland-66588325', '2023-08-24'),
('Climate warning as tree temperatures \'critical\'', 'https://bbc.com/news/uk-england-devon-66594806', '2023-08-24'),
('\'We\'re testing water for our children\'', 'https://bbc.com/news/uk-england-devon-65916304', '2023-08-22'),
('Lifeline for endangered insect feared extinct', 'https://bbc.com/news/science-environment-66531535', '2023-08-22'),
('Survey shows majority want beauty spot unchanged', 'https://bbc.com/news/uk-england-gloucestershire-66569440', '2023-08-21'),
('The water-stressed area turning businesses away', 'https://bbc.com/news/uk-england-suffolk-66504376', '2023-08-21'),
('Pioneering wind-powered cargo ship sets sail', 'https://bbc.com/news/technology-66543643', '2023-08-21'),
('Residents\' concerns over uncovered slurry lagoon', 'https://bbc.com/news/uk-england-cumbria-66541909', '2023-08-19'),
('Litter bins to be scrapped over cost concerns', 'https://bbc.com/news/uk-england-tees-66530188', '2023-08-17'),
('Sixty tonnes of rubbish removed from beaches', 'https://bbc.com/news/uk-england-cornwall-66528175', '2023-08-17'),
('Egg farmer halves pollution levels', 'https://bbc.com/news/articles/cmmy23rrvgdo', '2023-08-17'),
('Fly-tippers dump 15 fridges in Grimsby waterway', 'https://bbc.com/news/uk-england-humber-66522907', '2023-08-16'),
('\'Alarming\' temperature rise in UK\'s largest lake', 'https://bbc.com/news/uk-northern-ireland-66516358', '2023-08-16'),
('Struggling with asthma in world\'s most polluted city', 'https://bbc.com/news/world-asia-66496992', '2023-08-15'),
('Lottery money will enhance water park\'s wildlife', 'https://bbc.com/news/uk-england-gloucestershire-66501851', '2023-08-15'),
('River Wye waste not caused by farming, says NFU', 'https://bbc.com/news/uk-wales-66440390', '2023-08-14'),
('£9.5m sewage project protecting county’s rivers', 'https://bbc.com/news/uk-england-somerset-66495920', '2023-08-14'),
('Biggest fresh water lake in British Isles \'dying\'', 'https://bbc.com/news/uk-northern-ireland-66475360', '2023-08-12'),
('Oil taken off \'time bomb\' tanker abandoned off Yemen', 'https://bbc.com/news/world-middle-east-66481414', '2023-08-11'),
('Huge sewage discharge blamed on \'intense\' rainfall', 'https://bbc.com/news/articles/c2qd70k2162o', '2023-08-11'),
('How is sign language adapting to climate change?', 'https://bbc.com/news/science-environment-66464437', '2023-08-11'),
('Bid to block solar farm at High Court fails', 'https://bbc.com/news/articles/c6pwk021e87o', '2023-08-10'),
('Cement works plans £400m carbon capture facility', 'https://bbc.com/news/uk-wales-66453932', '2023-08-10'),
('Zac Goldsmith tempted to support Labour. Video, 00:00:43 Zac Goldsmith tempted to support Labour', 'https://bbc.com/news/uk-politics-66450086', '2023-08-09'),
('First zero-emission buses hit the streets of Derry', 'https://bbc.com/news/uk-northern-ireland-66437036', '2023-08-08'),
('Beyond Meat hit as cost of living squeezes shoppers', 'https://bbc.com/news/business-66435863', '2023-08-08'),
('Some 600 fish relocated for M25 upgrade', 'https://bbc.com/news/uk-england-essex-66428589', '2023-08-07'),
('UK\'s largest urban farm finds first season tough', 'https://bbc.com/news/uk-england-manchester-66403384', '2023-08-07'),
('Councils get £300,000 to pay for tree planting', 'https://bbc.com/news/uk-england-wiltshire-66372269', '2023-08-06'),
('£40k fundraiser launched to protect city woodland', 'https://bbc.com/news/uk-england-bristol-66397766', '2023-08-05'),
('Disaster averted as burnt car carrier reaches port', 'https://bbc.com/news/world-europe-66393507', '2023-08-03'),
('Amazon deforestation falls to lowest level since 2017', 'https://bbc.com/news/world-latin-america-66393360', '2023-08-03'),
('Net zero sceptics warm to Sunak climate shift', 'https://bbc.com/news/uk-politics-66388718', '2023-08-03'),
('Viking Bay pollution warning enters second day', 'https://bbc.com/news/articles/cv2p1zggn9do', '2023-08-02'),
('I care about reaching net zero, Sunak insists', 'https://bbc.com/news/uk-politics-66382265', '2023-08-02'),
('Pollution warning issued to Viking Bay swimmers', 'https://bbc.com/news/articles/c1vk64e562vo', '2023-08-01'),
('Blue-green algae warnings for beaches are removed', 'https://bbc.com/news/uk-northern-ireland-66361944', '2023-07-31'),
('PM to meet leaders over energy security plans', 'https://bbc.com/news/uk-politics-66350481', '2023-07-30'),
('Environmental groups warn PM over green pledges', 'https://bbc.com/news/uk-politics-66350486', '2023-07-29'),
('Portrush beaches red-flagged for toxic algae risk', 'https://bbc.com/news/uk-northern-ireland-66340899', '2023-07-28'),
('Bid to revoke peninsula theme park planning status', 'https://bbc.com/news/articles/czqynzw3z43o', '2023-07-28'),
('Could \'ethical\' Airbnb rival preserve communities?', 'https://bbc.com/news/uk-wales-66232498', '2023-07-28'),
('Dragons’ Den star warns time running out to act on climate', 'https://bbc.com/news/business-66293289', '2023-07-26'),
('Petrol and diesel car ban immovable, says Gove', 'https://bbc.com/news/uk-politics-66301051', '2023-07-25'),
('Rewilding project awarded £100k to expand', 'https://bbc.com/news/articles/c9xj7xz6r53o', '2023-07-25'),
('Bayer expects $2.8bn hit as weedkiller sales fall', 'https://bbc.com/news/business-66297589', '2023-07-25'),
('\'Habitat bank\' plan aims to boost biodiversity', 'https://bbc.com/news/uk-england-south-yorkshire-66292274', '2023-07-25'),
('Rhodes tourist felt she had been left to die', 'https://bbc.com/news/articles/c3ge33x6w32o', '2023-07-24'),
('Sunak \'pragmatic\' about meeting net zero target. Video, 00:00:39 Sunak \'pragmatic\' about meeting net zero target', 'https://bbc.com/news/uk-politics-66290539', '2023-07-24'),
('Meet London\'s youngest eco-warrior. Video, 00:01:25 Meet London\'s youngest eco-warrior', 'https://bbc.com/news/uk-england-london-66247311', '2023-07-24'),
('Beach clean-up sees plastic turned into art', 'https://bbc.com/news/uk-england-somerset-66274665', '2023-07-21'),
('Rare bird lured to Kent marshland to escape extreme heat', 'https://bbc.com/news/articles/c5138mvyv51o', '2023-07-21'),
('Watch the moment divers free trapped whale sharks. Video, 00:01:00 Watch the moment divers free trapped whale sharks', 'https://bbc.com/news/world-asia-66254335', '2023-07-20'),
('River to be \'re-meandered\' into more natural shape', 'https://bbc.com/news/uk-england-wiltshire-66238098', '2023-07-20'),
('Minister makes \'vote of confidence\' in Sizewell C', 'https://bbc.com/news/uk-england-suffolk-66240489', '2023-07-19'),
('Kayaker hails \'poo-centric\' expedition as a success', 'https://bbc.com/news/uk-england-suffolk-66232629', '2023-07-18'),
('Tip operator to dump more hazardous waste at site', 'https://bbc.com/news/uk-england-leeds-66230832', '2023-07-18'),
('Gardens in Tendring retain Green Flag Awards', 'https://bbc.com/news/uk-england-essex-66225529', '2023-07-18'),
('Virtual fencing introduced for grazing Mendip cows', 'https://bbc.com/news/articles/cz937ppv2g5o', '2023-07-17'),
('Is your pet fish damaging the environment?', 'https://bbc.com/news/uk-wales-66201178', '2023-07-15'),
('O macarrão feito de insetos que divide italianos', 'https://bbc.com/portuguese/articles/c030pd9dz4po', '2023-07-14'),
('\'Alarming and unprecedented\' Irish bird flu warning', 'https://bbc.com/news/articles/cglyrzx8rz7o', '2023-07-14'),
('Can these fish tanks prove radioactive water is safe? Video, 00:01:36 Can these fish tanks prove radioactive water is safe?', 'https://bbc.com/news/world-asia-66191784', '2023-07-13'),
('Beach industrial waste clearance signed off', 'https://bbc.com/news/uk-england-tyne-66187599', '2023-07-13'),
('Prosthetic legs made from binned household plastic', 'https://bbc.com/news/uk-wales-66174324', '2023-07-13'),
('Welsh Water downgraded over sewage pollution', 'https://bbc.com/news/uk-wales-66173170', '2023-07-12'),
('New global engine maker plans UK headquarters', 'https://bbc.com/news/business-66172158', '2023-07-12'),
('Prince William visits woodland set for expansion', 'https://bbc.com/news/uk-england-devon-66169614', '2023-07-11'),
('Farmers warned after beetle larvae pest found', 'https://bbc.com/news/articles/cp60e821lxpo', '2023-07-11'),
('New Forest pond reopens after restoration work', 'https://bbc.com/news/uk-england-hampshire-66153314', '2023-07-11'),
('Botanical gardens reveal £13m revamp', 'https://bbc.com/news/uk-england-birmingham-66152760', '2023-07-10'),
('The rush for nickel: \'They are destroying our future\'', 'https://bbc.com/news/world-asia-66131451', '2023-07-10'),
('Toxic algae warning extended along north coast', 'https://bbc.com/news/uk-northern-ireland-66148033', '2023-07-09'),
('Clean air zone delayed again over bus technology', 'https://bbc.com/news/uk-england-manchester-66142388', '2023-07-09'),
('Green bin charge plans opposed by thousands', 'https://bbc.com/news/uk-england-suffolk-66118515', '2023-07-06'),
('Ferrets and rats targeted in island puffin battle', 'https://bbc.com/news/uk-northern-ireland-66088620', '2023-07-05'),
('Memo reveals pressure on UK climate finance pledge', 'https://bbc.com/news/uk-66105901', '2023-07-05'),
('Thames Water fined £3.3m over river sewage', 'https://bbc.com/news/uk-england-sussex-66097906', '2023-07-04'),
('Ancient Dartmoor woodland to double in size', 'https://bbc.com/news/uk-england-devon-66096431', '2023-07-04'),
('Power plant could lose subsidies over compliance', 'https://bbc.com/news/uk-england-york-north-yorkshire-66066109', '2023-07-04'),
('Plan to protect South Yorkshire\'s green spaces', 'https://bbc.com/news/uk-england-south-yorkshire-66091669', '2023-07-04'),
('Water firm\'s pollution turned river black - court', 'https://bbc.com/news/uk-england-sussex-66088798', '2023-07-03'),
('Probe launched after human poo dumped in river', 'https://bbc.com/news/uk-wales-66091119', '2023-07-03'),
('June was hottest in Jersey since 1976 - forecasters', 'https://bbc.com/news/articles/cy753ly5d23o', '2023-07-03'),
('New Zealand bans plastic bags for fresh produce', 'https://bbc.com/news/business-66083337', '2023-07-03'),
('Sex life of rare \'leopard-print\' frog revealed', 'https://bbc.com/news/science-environment-66001590', '2023-07-01'),
('Humans hundreds of times \'deadlier\' than sharks', 'https://bbc.com/news/science-environment-66058976', '2023-06-30'),
('EU court finds Ireland failed to follow nature laws', 'https://bbc.com/news/articles/cy975d7wle9o', '2023-06-30');

-- --------------------------------------------------------

--
-- Table structure for table `trivia`
--

CREATE TABLE `trivia` (
  `id` int(11) NOT NULL,
  `question` text NOT NULL,
  `optionA` text NOT NULL,
  `optionB` text NOT NULL,
  `optionC` text NOT NULL,
  `optionD` text NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trivia`
--

INSERT INTO `trivia` (`id`, `question`, `optionA`, `optionB`, `optionC`, `optionD`, `answer`) VALUES
(1, 'More than 70% of our planet is covered by the ocean. But, do you know what percentage of the ocean is designated as protected?', '4%', '10%', '25%', '50%', '4%'),
(2, 'How many people depend on forests for their livelihoods?', '500 million', '900 million', '1.6 billion', '5 billion', '1.6 billion'),
(3, 'Our planet has already lost nearly 40% of its forests in the last three centuries. How many football pitches is that a minute?', '1', '5', '10', '20', '5'),
(4, 'Can you guess how many gorillas are walking the planet in 2018?', '1000', '2000', '4000', '8000', '1000'),
(5, 'If global temperatures rise by 1.5%, can you guess what percentage of the world’s wildlife will be at risk of extinction?', '5-10%', '10-20%', '20-30%', '30-40%', '20-30%'),
(6, 'What does the term biodiversity mean?', 'The total variety of all life on earth', 'Lots of wild habitats', 'Different types of species', 'The variety of characteristics within a species', 'The total variety of all life on earth'),
(7, 'What covers one third of the land’s surface, and helps to keep the climate stable by storing carbon?', 'Forests', 'Deserts', 'Grasslands', 'Rivers', 'Forests'),
(8, 'Why are pollinators such as bees so essential to life on earth?', 'They provide oxygen', 'They turn over the soil helping plants to grow', 'They help reduce pest populations', 'They help provide the food we eat', 'They help provide the food we eat'),
(9, 'Which of these species doesn’t have a home in the forest?', 'Grizzly bear', 'Great hornbill', 'Cheetah', 'Ring tailed lemur', 'Cheetah'),
(10, 'On land which animal only ever moves their hind legs together, however in the water they kick each leg independently to swim?', 'Rhinoceros', 'Kangaroo', 'Hornbill', 'Hippopotamus', 'Kangaroo');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registration_date` varchar(255) NOT NULL,
  `current_points` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `username`, `password`, `registration_date`, `current_points`) VALUES
('bobby123@gmail.com', 'Bobby', 'bobby123', '14/11/2023', 24),
('lauduanhang@gmail.com', 'Lau Duan Hang', 'duanhang', '06/11/2023', 0),
('qibin041227@gmail.com', 'qibin041227', 'bin12345', '01/11/2023', 101),
('qijingtee1227@gmail.com', 'qijingtee1227', 'jing1234', '01/11/2023', 0),
('sasa@gmail.com', 'Sasa', 'sasa1234', '05/11/2023', 0),
('test123@gmail.com', 'Test', 'test0000', '08/12/2023', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_trivia`
--

CREATE TABLE `user_trivia` (
  `email` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `attempts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_trivia`
--

INSERT INTO `user_trivia` (`email`, `id`, `attempts`) VALUES
('bobby123@gmail.com', 1, 2),
('bobby123@gmail.com', 2, 2),
('qibin041227@gmail.com', 1, 2),
('qibin041227@gmail.com', 2, 2),
('qibin041227@gmail.com', 3, 2),
('qibin041227@gmail.com', 4, 2),
('qibin041227@gmail.com', 5, 2),
('qibin041227@gmail.com', 6, 2),
('qibin041227@gmail.com', 7, 2),
('qibin041227@gmail.com', 8, 2),
('qibin041227@gmail.com', 9, 2),
('qibin041227@gmail.com', 10, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `home`
--
ALTER TABLE `home`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `trivia`
--
ALTER TABLE `trivia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `user_trivia`
--
ALTER TABLE `user_trivia`
  ADD PRIMARY KEY (`email`,`id`),
  ADD KEY `email` (`email`,`id`),
  ADD KEY `id` (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_trivia`
--
ALTER TABLE `user_trivia`
  ADD CONSTRAINT `user_trivia_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_trivia_ibfk_2` FOREIGN KEY (`id`) REFERENCES `trivia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
