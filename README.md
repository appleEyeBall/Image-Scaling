# Image-Scaling
An android class that works in d background, using AsyncTask.
This class takes an image and reduces its quality, by reducing it's
length and width to less than 400px (this value can be changed in the code).
It does this by dividing the original
length and width by a variable, called the "sampleSize" (Gotten from systematically
calculating this value for every image), which has to be a multiple of 2.
until the length and width is less than
400px (This value can be changed in the code).
