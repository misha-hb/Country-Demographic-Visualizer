# Country Demographic Visualizer

This system allows the user to see different demographic data from the World Bank’s data repository based on selected country and analysis type. 
The user logs into the system using their correct combination of username and password. If the combination is incorrect, they will be notified, and the application will terminate. Once they have logged in, the user can select a type for the analysis they wish to perform. Every time the analysis type is changed, the list of viewers or graphs is emptied. Next, they can choose a country from the drop-down menu. If the country selected fits the analysis type, then the data will be fetched. Otherwise, a message will be displayed indicating that data fetching is unavailable. The user can then pick a start and end year for the data to be displayed. If the years chosen are unavailable for the analysis type, the user is prompted to pick different years. The user can then add viewers they wish to see the data displayed in or remove other viewers.  Finally, the user can click the ‘Recalculate’ button to compute the specific analysis using the individual pieces of data, if needed, or the data can just be shown as retrieved. The viewers then display the data.

## Installation

Install Eclipse IDE for Java and download the project. Run LoginWindow in login.

## Testing the system

Enter a valid username and password (e.g. ajackson23, uwoPassWord) and click submit. Choose an analysis type first, then make selections for a country, start/end years, and viewers. When all selections are made, click "Recalculate" for the viewers to display the analysis data.

## Authors
Misha Butt, Emily Missetta Grant , Marshall Mevissen Moore , Jennifer Yoon