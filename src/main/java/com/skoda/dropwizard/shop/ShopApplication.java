package com.skoda.dropwizard.shop;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import com.skoda.dropwizard.shop.core.Person;
import com.skoda.dropwizard.shop.db.PersonDAO;
import com.skoda.dropwizard.shop.resources.PeopleResource;
import com.skoda.dropwizard.shop.resources.PersonResource;

public class ShopApplication extends Application<ShopConfiguration> {

	private final HibernateBundle<ShopConfiguration> hibernateBundle = new HibernateBundle<ShopConfiguration>(Person.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(
				ShopConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};
	
	public static void main(String[] args) throws Exception {
		new ShopApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<ShopConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<ShopConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ShopConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());

	}

	@Override
	public void run(ShopConfiguration configuration, Environment environment) throws Exception {
		PersonDAO dao = new PersonDAO(hibernateBundle.getSessionFactory());
		environment.jersey().register(new PeopleResource(dao));
		environment.jersey().register(new PersonResource(dao));

	}

}
