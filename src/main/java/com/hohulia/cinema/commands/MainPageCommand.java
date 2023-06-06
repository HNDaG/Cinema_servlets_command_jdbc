package com.hohulia.cinema.commands;

import com.hohulia.cinema.entities.Movie;
import com.hohulia.cinema.exceptions.ServiceException;
import com.hohulia.cinema.services.MovieService;
import com.hohulia.cinema.services.ScheduleService;
import com.hohulia.cinema.services.ServiceFactory;
import com.hohulia.cinema.utilities.ImgPaths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class MainPageCommand implements ICommand{
    private final MovieService movieService = ServiceFactory.getMovieService();
    private final ScheduleService scheduleService = ServiceFactory.getScheduleService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<List<Movie>> movies = movieService.getNearestMovies();
            Map<String, String> paths = ImgPaths.getImgPaths(movies);

            request.setAttribute("paths", paths);
            request.setAttribute("moviesToday", movies.get(0));
            request.setAttribute("moviesTomorrow", movies.get(1));
            request.setAttribute("moviesTheDayAfterTomorrow", movies.get(2));
            return "/WEB-INF/index.jsp";
        }catch(ServiceException e) {
            request.setAttribute("error", e.getMessage());
            return "!/error";
        }




    }
}
