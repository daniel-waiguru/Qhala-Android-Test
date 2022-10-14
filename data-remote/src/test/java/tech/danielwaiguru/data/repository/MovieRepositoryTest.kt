package tech.danielwaiguru.data.repository

/*
@RunWith(RobolectricTestRunner::class)
class MovieRepositoryTest: BaseTest() {
    private lateinit var movieRepository: MovieRepository
    override fun setup() {
        super.setup()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val movieDb = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java).build()
        movieRepository = MovieRepositoryImpl(apiService, movieDb.getMovieDao())
    }
    @Test
    fun `test fetching popular movies returns movie list`() = runBlocking {
        val movies = movieRepository.getPopularMovies()
        movies.collect {
            Truth.assertThat(it.size).isAtLeast(1)
        }
    }
}*/
