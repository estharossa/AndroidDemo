package com.example.androiddemo.model

/**
 * [
 *   {
 *     "name": "John Doe",
 *     "age": 30,
 *     "gender": "male",
 *     "occupation": "software engineer",
 *     "email": "johndoe@example.com",
 *     "phone": "+1234567890",
 *     "address": {
 *       "street": "123 Main St",
 *       "city": "Anytown",
 *       "state": "ST",
 *       "zip": "12345",
 *       "country": "USA"
 *     },
 *     "education": {
 *       "degree": "Bachelor of Science",
 *       "major": "Computer Science",
 *       "school": "University of Example"
 *     },
 *     "skills": [
 *       "Java",
 *       "Python",
 *       "JavaScript"
 *     ],
 *     "languages": [
 *       "English",
 *       "Spanish"
 *     ],
 *     "interests": [
 *       "Reading",
 *       "Hiking",
 *       "Gaming"
 *     ]
 *   }
 * ]
 */
data class Person(
    val name: String,
    val age: Int,
    val gender: String,
    val occupation: String,
    val email: String,
    val phone: String,
    val languages: List<String>,
    val education: Education
)
